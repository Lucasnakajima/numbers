package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class ListDeduplicatorTest {

    private List<Integer> list, expected;

    @BeforeEach
    void helper(){
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        ListDeduplicator deduplicator = new ListDeduplicator();
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicating() {

        class Stub implements GenericListSorter{

            @Override
            public List<Integer> sort(List<Integer> list) {
                return Arrays.asList(1,2,2,4);
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(new Stub());

        List<Integer> distinct = deduplicator.deduplicate(Arrays.asList(1,2,4,2));

        Assertions.assertEquals(Arrays.asList(1,2,4), distinct);
    }
}
