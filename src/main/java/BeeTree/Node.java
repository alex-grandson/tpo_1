package BeeTree;

import java.util.ArrayList;

class Node {
    private final ArrayList<Integer> key;
    private final ArrayList<Node> children;
    private Node parent;
    private Node next;
    private final int maxKeys;

    public Node(int maxKeys) {
        this.maxKeys = maxKeys;
        this.key = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }

    public boolean isRoot() {
        return this.parent == null;
    }

    public boolean canAddChildren() {
        return this.children.size() < this.maxKeys + 1;
    }

    public boolean canAddKey() {
        return this.key.size() < this.maxKeys;
    }

    public boolean addKey(Integer key) {
        int i;
        for (i = 0; i < this.key.size(); i++) {
            if (key < this.key.get(i)) {
                this.key.add(i, key);
                return true;
            }
        }
        this.key.add(i, key);
        return true;
    }

    public boolean addChild(Node node) {
        node.setParent(this);
        if (children.size() == 0) {
            return this.children.add(node);
        }

        int key = node.key.get(0);
        if (key < this.key.get(0)) {
            node.setNext(children.get(0));
            children.add(0, node);
            return true;
        }
        int i;
        for (i = 1; i < this.key.size(); i++) {
            if (key < this.key.get(i)) {
                children.get(i - 1).setNext(node);
                node.setNext(children.get(i));
                children.add(i, node);
                return true;
            }
        }
        children.get(i - 1).setNext(node);
        return this.children.add(node);
    }

    public void moveLastKeysToNode(Node node, int amount) {
        for (int i = 0; i < amount && key.size() > 0; i++) {
            node.getKey().add(0, key.remove(key.size() - 1));
        }
    }

    public void moveLastChildrenToNode(Node node, int amount) {
        for (int i = 0; i < amount && children.size() > 0; i++) {
            node.getChildren().add(0, children.remove(children.size() - 1));
        }
    }

    public Node split() {
        Node node = new Node(maxKeys);
        this.moveLastKeysToNode(node, Math.floorDiv(key.size(), 2));
        this.moveLastChildrenToNode(node, Math.floorDiv(children.size(), 2));
        return node;
    }

    public Node addKeyAndSplit(int key) {
        this.addKey(key);
        return this.split();
    }

    public Node addChildAndSplit(Node node) {
        this.addKey(node.getKey().get(0));
        this.addChild(node);
        return this.split();
    }

    public ArrayList<Integer> getKey() {
        return key;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public Node getParent() {
        return parent;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}