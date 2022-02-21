import bTree.BeeTree;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("BeeTree tests")
public class BeeTreeTest {
    private final int maxKeys = 4;
    private BeeTree beeTree;

    @BeforeEach
    public void setup() {
        beeTree = new BeeTree(maxKeys, true);
    }

    @ParameterizedTest(name = "Contains array ({0})")
    @CsvFileSource(resources = "/BeeTree/BeeTree_test_has_keys.csv")
    void containsTest(String arrayText) {
        int[] array = Arrays.stream(arrayText.replaceAll(" ", "").split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(array).forEach(beeTree::add);
        int size = array.length;
        boolean[] trueArray = new boolean[size];
        Arrays.fill(trueArray, true);
        boolean[] actualArray = new boolean[size];
        for (int i = 0; i < size; i++) {
            actualArray[i] = beeTree.hasKey(array[i]);
        }
        assertArrayEquals(trueArray, actualArray);
    }

    @ParameterizedTest(name = "Leafs of array ({0})")
    @CsvFileSource(resources = "/BeeTree/BeeTree_test_leafs.csv")
    void leafTest (String input, String expected) {
        int[] array = Arrays.stream(input.replaceAll(" ", "").split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(array).forEach(beeTree::add);
        String actual = beeTree.toLeafString();
        System.out.printf("expected = %30s | actual = %30s | input = %30s\n",
                expected, actual, input);
        if (!expected.equals(actual)) {
            System.out.println("History:\n");
            System.out.println(beeTree.toHistoryString());
        }
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "Keys of array ({0})")
    @CsvFileSource(resources = "/BeeTree/BeeTree_test_keys.csv")
    void keysTest (String input, String expected) {
        int[] array = Arrays.stream(input.replaceAll(" ", "").split(";"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.stream(array).forEach(beeTree::add);
        String actual = beeTree.toNodeString();
        System.out.printf("expected = %30s | actual = %30s | input = %30s\n",
                expected, actual, input);
        if (!expected.equals(actual)) {
            System.out.println("History:\n");
            System.out.println(beeTree.toHistoryString());
        }
        assertEquals(expected, actual);
    }
}
