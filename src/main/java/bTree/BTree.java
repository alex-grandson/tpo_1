package bTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// пчеловое дерево
public class BTree {
    private Node root;
    private final int maxKeys;
    private final boolean saveHistory;
    private List<String> history;

    public BTree(int maxKeys) {
        this(maxKeys, false);
    }

    public BTree(int maxKeys, boolean saveHistory) {
        this.maxKeys = maxKeys;
        this.root = new Node(maxKeys);
        this.saveHistory = saveHistory;
        if (saveHistory) {
            history = new LinkedList<>();
        }
    }

    public Node findNode(Integer key) {
        return findNode(key, this.root);
    }

    public Node findNode(Integer key, Node node) {
        if (node.isLeaf()) return node;

        ArrayList<Integer> keys = node.getKey();
        ArrayList<Node> children = node.getChildren();

        int size = keys.size();
        for (int i = 0; i < size; i++) {
            if (key <= keys.get(i)) {
                return findNode(key, children.get(i));
            }
        }
        return findNode(key, children.get(size));
    }

    public boolean hasKey(Integer key) {
        return getAllKeys().stream().anyMatch(it -> it.equals(key));
    }

    public Node findFirstLeaf() {
        return findFirstLeaf(root);
    }

    public Node findFirstLeaf(Node node) {
        if (node.isLeaf()) return node;
        return findFirstLeaf(node.getChildren().get(0));
    }

    public LinkedList<Node> getLeafs() {
        LinkedList<Node> leafs = new LinkedList<>();
        Node node = findFirstLeaf();
        leafs.add(node);
        while (node.hasNext()) {
            node = node.getNext();
            leafs.add(node);
        }
        return leafs;
    }

    public List<Integer> getAllKeys() {
        return getLeafs().stream()
                .flatMap(it -> it.getKey().stream())
                .collect(Collectors.toList());
    }

    public String toLeafString() {
        return toLeafString("; ");
    }

    public String toLeafString(String delimiter) {
        return getAllKeys().stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    public String toNodeString() {
        return toNodeString(root, "; ", "[", "]");
    }

    public String toNodeString(String delimiter, String prefix, String postfix) {
        return toNodeString(root, delimiter, prefix, postfix);
    }

    public String toNodeString(Node node, String delimiter, String prefix, String postfix) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(prefix);

        String keysString = node.getKey().stream()
                .map(Object::toString)
                .collect(Collectors.joining(delimiter));
        stringBuilder.append(keysString);

        if (!node.isLeaf()) {
            stringBuilder.append(delimiter);
            String childrenString = node.getChildren().stream()
                    .map(it -> toNodeString(it, delimiter, prefix, postfix))
                    .collect(Collectors.joining(delimiter));
            stringBuilder.append(childrenString);
        }
        stringBuilder.append(postfix);
        return stringBuilder.toString();
    }

    public String toHistoryString() {
        if (!saveHistory) throw new IllegalStateException("History saving is disabled");
        if (history.size() == 0) return "";
        return String.join("\n", history);
    }

    public void add(Integer value) {
        Node found = findNode(value);
        if (found.canAddKey() && found.addKey(value)) {
            this.saveHistoryPoint();
            return;
        }
        this.splitAndInsert(found, value);
        this.saveHistoryPoint();
    }

    private void createNewRoot(Node left, Node right) {
        Node newRoot = new Node(this.maxKeys);
        newRoot.addKey(right.getKey().get(0));
        newRoot.addChild(left);
        newRoot.addChild(right);
        this.root = newRoot;
    }

    private void addChildrenToNode(Node target, Node nodeToAdd) {
        if (
                target.canAddKey() &&
                        target.addKey(nodeToAdd.getKey().get(0)) &&
                        target.canAddChildren() &&
                        target.addChild(nodeToAdd)
        ) {
            return;
        }
        Node newNode = target.addChildAndSplit(nodeToAdd);
        if (target.isRoot()) {
            this.createNewRoot(target, newNode);
            return;
        }
        this.addChildrenToNode(target.getParent(), newNode);
    }

    private void splitAndInsert(Node node, int value) {
        Node rightNode = node.addKeyAndSplit(value);
        if (!node.isRoot()) {
            this.addChildrenToNode(node.getParent(), rightNode);
        } else {
            this.createNewRoot(node, rightNode);
        }
    }

    private void saveHistoryPoint() {
        if (!saveHistory) return;
        history.add(toNodeString());
    }



}
