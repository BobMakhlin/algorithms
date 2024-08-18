package com.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublySinglyLinkedListTest {
    @Test
    void shouldAppend() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertEquals(3, list.size());
        assertEquals(1, list.toList().get(0));
        assertEquals(2, list.toList().get(1));
        assertEquals(3, list.toList().get(2));
    }

    @Test
    void shouldPrepend() {
        var list = new DoublyLinkedList<Integer>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        assertEquals(3, list.size());
        assertEquals(3, list.toList().get(0));
        assertEquals(2, list.toList().get(1));
        assertEquals(1, list.toList().get(2));
    }

    @Test
    void shouldRemoveLast() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertTrue(list.removeLast());
        assertEquals(2, list.size());
        assertEquals(1, list.toList().get(0));
        assertEquals(2, list.toList().get(1));
    }

    @Test
    void shouldRemoveFirst() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        assertTrue(list.removeFirst());
        assertEquals(2, list.size());
        assertEquals(2, list.toList().get(0));
        assertEquals(3, list.toList().get(1));
    }

    @Test
    void shouldNotRemoveFirstWhenEmpty() {
        var list = new DoublyLinkedList<Integer>();
        Assertions.assertFalse(list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    void shouldRemoveFirstWhenContainsOneItem() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        assertTrue(list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    void shouldNotRemoveLastWhenEmpty() {
        var list = new DoublyLinkedList<Integer>();
        Assertions.assertFalse(list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void shouldRemoveLastWhenContainsOneItem() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        assertTrue(list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void shouldGetWhenOddNumberOfNodes() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
        assertEquals(5, list.get(4));
    }

    @Test
    void shouldGetWhenEvenNumberOfNodes() {
        var list = new DoublyLinkedList<Integer>();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Nested
    class Insert {
        @Test
        void shouldInsertIntoMiddle() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.insert(1, 100);
            assertEquals(4, list.size());
            assertEquals(1, list.toList().get(0));
            assertEquals(100, list.toList().get(1));
            assertEquals(2, list.toList().get(2));
            assertEquals(3, list.toList().get(3));
        }

        @Test
        void shouldInsertIntoBeginning() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.insert(0, 100);
            assertEquals(4, list.size());
            assertEquals(100, list.toList().get(0));
            assertEquals(1, list.toList().get(1));
            assertEquals(2, list.toList().get(2));
            assertEquals(3, list.toList().get(3));
        }

        @Test
        void shouldInsertIntoEnd() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.insert(3, 100);
            assertEquals(4, list.size());
            assertEquals(1, list.toList().get(0));
            assertEquals(2, list.toList().get(1));
            assertEquals(3, list.toList().get(2));
            assertEquals(100, list.toList().get(3));
        }

        @Test
        void shouldInsertIntoEmptyList() {
            var list = new DoublyLinkedList<Integer>();
            list.insert(0, 100);
            assertEquals(1, list.size());
            assertEquals(100, list.toList().get(0));
        }

        @Test
        void shouldThrowIfInsertingWithWrongIndex() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.insert(4, 100));
        }
    }

    @Nested
    class Remove {
        @Test
        void shouldRemoveElementAtBeginningOfList() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);

            list.remove(0);

            assertEquals(4, list.size());
            assertEquals(2, list.get(0));
        }

        @Test
        void shouldRemoveElementInMiddleOfList() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);

            list.remove(2);

            assertEquals(4, list.size());
            assertEquals(4, list.get(2));
        }

        @Test
        void shouldRemoveElementAtEndOfList() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);

            list.remove(list.size() - 1);

            assertEquals(4, list.size());
        }

        @Test
        void shouldThrowWhenRemovingNonexistentIndex() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);

            assertThrows(IndexOutOfBoundsException.class, () -> list.remove(10));
        }

        @Test
        void shouldThrowWhenRemovingFromEmptyList() {
            var list = new DoublyLinkedList<Integer>();
            assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        }
    }

    @Nested
    class Reverse {
        @Test
        void shouldReverseEmptyList() {
            var list = new DoublyLinkedList<Integer>();

            list.reverse();

            assertEquals(0, list.size());
        }

        @Test
        void shouldReverseListWithSingleElement() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);

            list.reverse();

            assertEquals(1, list.size());
            assertEquals(1, list.get(0));
        }

        @Test
        void shouldReverseListOfMultipleElements() {
            var list = new DoublyLinkedList<Integer>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.append(6);

            list.reverse();

            assertEquals(6, list.size());
            assertEquals(6, list.get(0));
            assertEquals(5, list.get(1));
            assertEquals(4, list.get(2));
            assertEquals(3, list.get(3));
            assertEquals(2, list.get(4));
            assertEquals(1, list.get(5));
        }
    }

    @Nested
    class SwapPairs {
        @Test
        public void shouldSwapPairsInEmptyList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.swapPairs();
            assertEquals(0, list.size());
        }

        @Test
        public void shouldSwapPairsInSingleItemList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.append(1);
            list.swapPairs();
            assertEquals(1, list.size());
            assertEquals(1, list.get(0));
        }

        @Test
        public void shouldSwapPairsInTwoItemList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.append(1);
            list.append(2);
            list.swapPairs();
            assertEquals(2, list.size());
            assertEquals(2, list.get(0));
            assertEquals(1, list.get(1));
        }

        @Test
        public void shouldSwapPairsInThreeItemList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.swapPairs();
            assertEquals(3, list.size());
            assertEquals(2, list.get(0));
            assertEquals(1, list.get(1));
            assertEquals(3, list.get(2));
        }

        @Test
        public void shouldSwapPairsInFourItemList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.swapPairs();
            assertEquals(4, list.size());
            assertEquals(2, list.get(0));
            assertEquals(1, list.get(1));
            assertEquals(4, list.get(2));
            assertEquals(3, list.get(3));
        }

        @Test
        public void shouldSwapPairsInMultipleItemsList() {
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
            list.append(1);
            list.append(2);
            list.append(3);
            list.append(4);
            list.append(5);
            list.append(6);
            list.swapPairs();
            assertEquals(6, list.size());
            assertEquals(2, list.get(0));
            assertEquals(1, list.get(1));
            assertEquals(4, list.get(2));
            assertEquals(3, list.get(3));
            assertEquals(6, list.get(4));
            assertEquals(5, list.get(5));
        }

        @Test
        public void shouldSwapPairsInStringList() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.append("a");
            list.append("b");
            list.append("c");
            list.append("d");
            list.swapPairs();
            assertEquals(4, list.size());
            assertEquals("b", list.get(0));
            assertEquals("a", list.get(1));
            assertEquals("d", list.get(2));
            assertEquals("c", list.get(3));
        }
    }

    @Nested
    class IsPalindrome {
        @Test
        public void shouldReturnTrueWhenSingleItem() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.append("A");
            assertTrue(list.isPalindrome());
        }

        @Test
        public void shouldReturnTrueWhenMultipleIdenticalItems() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.append("A");
            list.append("A");
            assertTrue(list.isPalindrome());
        }

        @Test
        public void shouldReturnTrueWhenItemsFormPalindrome() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.append("E");
            list.append("D");
            list.append("A");
            list.append("B");
            list.append("A");
            list.append("D");
            list.append("E");
            assertTrue(list.isPalindrome());
        }

        @Test
        public void shouldReturnFalseWhenItemsDoNotFormPalindrome() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            list.append("A");
            list.append("B");
            assertFalse(list.isPalindrome());
        }

        @Test
        public void shouldReturnFalseWhenEmpty() {
            DoublyLinkedList<String> list = new DoublyLinkedList<>();
            assertFalse(list.isPalindrome());
        }
    }
}