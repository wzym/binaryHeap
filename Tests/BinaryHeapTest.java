import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {
    private final int ARRAY_SIZE_DIAPASON = 1000;
    private final int MIN_ARRAY_SIZE = 13;
    private final int MAX_ELEMENT_SIZE = 100;

    @Test
    public void simpleOrderTest() {
        Integer[] randomIntegers = getRandomIntegerArray();
        BinaryHeap heap = new BinaryHeap<Integer, Integer>();
        for (Integer randomInteger : randomIntegers) {
            heap.insert(randomInteger, randomInteger);
        }
        Integer currentPeak = MAX_ELEMENT_SIZE + 1;
        while (!heap.isEmpty()) {
            Integer lastPeak = currentPeak;
            currentPeak = heap.getMax();
            Assert.assertTrue(lastPeak >= currentPeak);
        }
    }

    private Integer[] getRandomIntegerArray() {
        int size = (int) Math.round(Math.random() * ARRAY_SIZE_DIAPASON) + MIN_ARRAY_SIZE;
        Integer[] result = new Integer[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) Math.round(Math.random() * MAX_ELEMENT_SIZE);
        }
        return result;
    }
}