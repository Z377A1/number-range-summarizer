package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class NumberRangeSummarizerImplTest {

    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    @Test
    void testCollectValidInput() {
        Collection<Integer> result = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        assertEquals(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31), result);
    }

    @Test
    void testCollectHandlesWhitespaceAndDuplicates() {
        Collection<Integer> result = summarizer.collect(" 1 , 1 , 2 , 3 , 5 ");
        assertEquals(Arrays.asList(1,2,3,5), result);
    }

    @Test
    void testCollectSkipsInvalidNumbers() {
        Collection<Integer> result = summarizer.collect("1, x, 2, y, 3");
        assertEquals(Arrays.asList(1,2,3), result);
    }

    @Test
    void testCollectEmptyString() {
        Collection<Integer> result = summarizer.collect("");
        assertTrue(result.isEmpty());
    }

    @Test
    void testSummarizeCollectionStandardCase() {
        String result = summarizer.summarizeCollection(Arrays.asList(1,3,6,7,8,12,13,14,15,21,22,23,24,31));
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }

    @Test
    void testSummarizeCollectionSingleElement() {
        String result = summarizer.summarizeCollection(Collections.singletonList(5));
        assertEquals("5", result);
    }

    @Test
    void testSummarizeCollectionEmptyInput() {
        String result = summarizer.summarizeCollection(Collections.emptyList());
        assertEquals("", result);
    }

    @Test
    void testSummarizeCollectionUnsortedInput() {
        String result = summarizer.summarizeCollection(Arrays.asList(5,4,3,2,1));
        assertEquals("1-5", result);
    }
}
