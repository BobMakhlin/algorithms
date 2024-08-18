package com.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SinglyLinkedListTest {
    @Test
    void shouldAppend() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(3, list.toList().get(2));
    }

    @Test
    void shouldPrepend() {
        var list = new SinglyLinkedList<Integer>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(3, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(1, list.toList().get(2));
    }

    @Test
    void shouldRemoveLast() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertTrue(list.removeLast());
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
    }

    @Test
    void shouldRemoveFirst() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertTrue(list.removeFirst());
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(2, list.toList().get(0));
        Assertions.assertEquals(3, list.toList().get(1));
    }

    @Test
    void shouldNotRemoveFirstWhenEmpty() {
        var list = new SinglyLinkedList<Integer>();
        Assertions.assertFalse(list.removeFirst());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldRemoveFirstWhenContainsOneItem() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        Assertions.assertTrue(list.removeFirst());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldNotRemoveLastWhenEmpty() {
        var list = new SinglyLinkedList<Integer>();
        Assertions.assertFalse(list.removeLast());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldRemoveLastWhenContainsOneItem() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        Assertions.assertTrue(list.removeLast());
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldSet() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.set(0, 11);
        list.set(1, 12);
        list.set(2, 13);
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(11, list.toList().get(0));
        Assertions.assertEquals(12, list.toList().get(1));
        Assertions.assertEquals(13, list.toList().get(2));
    }

    @Test
    void shouldThrowWhenSettingWithWrongIndex() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(100, 11));
    }

    @Test
    void shouldThrowWhenSettingIntoEmptyList() {
        var list = new SinglyLinkedList<Integer>();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 11));
    }

    @Test
    void shouldInsertIntoMiddle() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(1, 100);
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(100, list.toList().get(1));
        Assertions.assertEquals(2, list.toList().get(2));
        Assertions.assertEquals(3, list.toList().get(3));
    }

    @Test
    void shouldInsertIntoBeginning() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(0, 100);
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(100, list.toList().get(0));
        Assertions.assertEquals(1, list.toList().get(1));
        Assertions.assertEquals(2, list.toList().get(2));
        Assertions.assertEquals(3, list.toList().get(3));
    }

    @Test
    void shouldInsertIntoEnd() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.insert(3, 100);
        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(3, list.toList().get(2));
        Assertions.assertEquals(100, list.toList().get(3));
    }

    @Test
    void shouldInsertIntoEmptyList() {
        var list = new SinglyLinkedList<Integer>();
        list.insert(0, 100);
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(100, list.toList().get(0));
    }

    @Test
    void shouldThrowIfInsertingWithWrongIndex() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 100));
    }

    @Test
    void shouldReverseListOf2Items() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.reverse();
        Assertions.assertEquals(2, list.size());
        Assertions.assertEquals(2, list.toList().get(0));
        Assertions.assertEquals(1, list.toList().get(1));
    }

    @Test
    void shouldNotFailReversingListOf1Item() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.reverse();
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
    }

    @Test
    void shouldNotFailReversingEmptyList() {
        var list = new SinglyLinkedList<Integer>();
        list.reverse();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldReverse() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.reverse();
        Assertions.assertEquals(6, list.size());

        Assertions.assertEquals(6, list.toList().get(0));
        Assertions.assertEquals(5, list.toList().get(1));
        Assertions.assertEquals(4, list.toList().get(2));
        Assertions.assertEquals(3, list.toList().get(3));
        Assertions.assertEquals(2, list.toList().get(4));
        Assertions.assertEquals(1, list.toList().get(5));
    }

    @Test
    void shouldFindMiddleWhenOddNumberOfItems() {
        var myList = new SinglyLinkedList<Integer>();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        Assertions.assertEquals(3, myList.findMiddle());
    }

    @Test
    void shouldFindMiddleWhenEvenNumberOfItems() {
        var myList = new SinglyLinkedList<Integer>();
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(4);
        myList.append(5);
        myList.append(6);
        Assertions.assertEquals(4, myList.findMiddle());
    }

    @Test
    void shouldFindMiddleInListOf1Item() {
        var myList = new SinglyLinkedList<Integer>();
        myList.append(1);
        Assertions.assertEquals(1, myList.findMiddle());
    }

    @Nested
    class FindKthFromEnd {
        @Test
        void shouldFindKthFromEndLocatedAfterMiddle() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            Assertions.assertEquals(5, myList.findByIndexFromEnd(2));
        }

        @Test
        void shouldFindKthFromEndLocatedBeforeMiddle() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            myList.append(8);
            myList.append(9);
            Assertions.assertEquals(5, myList.findByIndexFromEnd(4));
        }

        @Test
        void shouldNotFindKthFromEnd() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            Assertions.assertNull(myList.findByIndexFromEnd(7));
        }

        @Test
        void shouldFindKthFromEndLocatedAfterMiddleWhenEvenNumberOfItems() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            myList.append(8);
            myList.append(9);
            myList.append(10);
            myList.append(11);
            myList.append(12);
            Assertions.assertEquals(10, myList.findByIndexFromEnd(2));
        }

        @Test
        void shouldFindKthFromEndLocatedBeforeMiddleWhenEvenNumberOfItems() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            myList.append(8);
            myList.append(9);
            myList.append(10);
            myList.append(11);
            myList.append(12);
            Assertions.assertEquals(1, myList.findByIndexFromEnd(11));
        }

        @Test
        void shouldNotFindKthFromEndWhenEvenNumberOfItems() {
            var myList = new SinglyLinkedList<Integer>();
            myList.append(1);
            myList.append(2);
            myList.append(3);
            myList.append(4);
            myList.append(5);
            myList.append(6);
            myList.append(7);
            myList.append(8);
            myList.append(9);
            myList.append(10);
            myList.append(11);
            myList.append(12);
            Assertions.assertNull(myList.findByIndexFromEnd(15));
        }

        @Test
        void shouldFindKthFromEndInLargeList() {
            var myList = new SinglyLinkedList<Integer>();
            for (int i = 1; i <= 10000; i++) {
                myList.append(i);
            }
            Assertions.assertEquals(9990, myList.findByIndexFromEnd(10));
        }
    }

    @Test
    void shouldPartitionBy5() {
        var list = new SinglyLinkedList<Integer>();
        list.append(3);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);
        list.partitionBy(5, Integer::compare);

        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals(3, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(1, list.toList().get(2));
        Assertions.assertEquals(8, list.toList().get(3));
        Assertions.assertEquals(5, list.toList().get(4));
        Assertions.assertEquals(10, list.toList().get(5));
    }

    @Test
    void shouldPartitionBy3() {
        var list = new SinglyLinkedList<Integer>();
        list.append(4);
        list.append(1);
        list.append(3);
        list.append(2);
        list.append(5);
        list.append(2);
        list.partitionBy(3, Integer::compare);

        Assertions.assertEquals(6, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(2, list.toList().get(2));
        Assertions.assertEquals(4, list.toList().get(3));
        Assertions.assertEquals(3, list.toList().get(4));
        Assertions.assertEquals(5, list.toList().get(5));
    }

    @Test
    void shouldNotFailRemovingDupsInEmptyList() {
        var list = new SinglyLinkedList<Integer>();
        list.removeDuplicates();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void shouldNotFailRemovingDupsInSingleItemList() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.removeDuplicates();
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void shouldRemoveDuplicates() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(1);
        list.append(4);
        list.append(2);
        list.append(5);
        list.append(1);
        list.append(1);
        list.append(1);
        list.removeDuplicates();
        Assertions.assertEquals(5, list.size());
        Assertions.assertEquals(1, list.toList().get(0));
        Assertions.assertEquals(2, list.toList().get(1));
        Assertions.assertEquals(3, list.toList().get(2));
        Assertions.assertEquals(4, list.toList().get(3));
        Assertions.assertEquals(5, list.toList().get(4));
    }

    @Nested
    class ReverseInBetween {
        @Test
        void shouldThrowIfEndIndexOutOfBound() {
            var list = new SinglyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.reverseBetween(0, 5));
        }

        @Test
        void shouldThrowIfRangeInvalid() {
            var list = new SinglyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.reverseBetween(3, 1));
        }

        @Test
        void shouldThrowIfStartIndexSameAsEndIndex() {
            var list = new SinglyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.reverseBetween(3, 3));
        }

        @Test
        void shouldThrowIfStartIndexNegative() {
            var list = new SinglyLinkedList<Integer>();
            Assertions.assertThrows(IllegalArgumentException.class, () -> list.reverseBetween(-100, 3));
        }

        @Test
        void shouldReverseInTheMiddle() {
            var list = new SinglyLinkedList<Integer>();
            list.append(0);
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.reverseBetween(2, 4);
            Assertions.assertEquals(6, list.size());
            Assertions.assertEquals(0, list.toList().get(0));
            Assertions.assertEquals(1, list.toList().get(1));
            Assertions.assertEquals(4, list.toList().get(2));
            Assertions.assertEquals(3, list.toList().get(3));
            Assertions.assertEquals(2, list.toList().get(4));
            Assertions.assertEquals(5, list.toList().get(5));
        }

        @Test
        void shouldReverseInTheBeginning() {
            var list = new SinglyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.reverseBetween(0, 2);
            Assertions.assertEquals(5, list.size());

            Assertions.assertEquals(3, list.toList().get(0));
            Assertions.assertEquals(2, list.toList().get(1));
            Assertions.assertEquals(1, list.toList().get(2));
            Assertions.assertEquals(4, list.toList().get(3));
            Assertions.assertEquals(5, list.toList().get(4));
        }

        @Test
        void shouldReverseInTheEnd() {
            var list = new SinglyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.reverseBetween(2, 4);
            Assertions.assertEquals(5, list.size());

            Assertions.assertEquals(1, list.toList().get(0));
            Assertions.assertEquals(2, list.toList().get(1));
            Assertions.assertEquals(5, list.toList().get(2));
            Assertions.assertEquals(4, list.toList().get(3));
            Assertions.assertEquals(3, list.toList().get(4));
        }

        @Test
        void shouldReverseTheWholeList() {
            var list = new SinglyLinkedList<Integer>();
            list.append(0);
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.reverseBetween(0, 5);
            Assertions.assertEquals(6, list.size());
            Assertions.assertEquals(5, list.toList().get(0));
            Assertions.assertEquals(4, list.toList().get(1));
            Assertions.assertEquals(3, list.toList().get(2));
            Assertions.assertEquals(2, list.toList().get(3));
            Assertions.assertEquals(1, list.toList().get(4));
            Assertions.assertEquals(0, list.toList().get(5));
        }
    }

    @Test
    public void testMergeSorted() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();

        // Adding elements to the first list
        list1.append(3);
        list1.append(5);
        list1.append(8);
        list1.append(20);

        // Adding elements to the second list
        list2.append(1);
        list2.append(2);
        list2.append(4);
        list2.append(9);
        list2.append(10);
        list2.append(100);
        list2.append(200);

        // Merging both lists
        list1.mergeSorted(list2);

        // Verify the correct order
        Assertions.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 8, 9, 10, 20, 100, 200), list1.toList());
    }
}