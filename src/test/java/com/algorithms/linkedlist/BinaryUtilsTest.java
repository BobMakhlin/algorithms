package com.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryUtilsTest {
    @Test
    public void shouldConvertBinary10101ToDecimal21() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(0);
        list.append(1);
        list.append(0);
        list.append(1);
        Assertions.assertEquals(21, BinaryUtils.binaryToDecimal(list));
    }

    @Test
    public void shouldReturnZeroForBinaryAllZeros() {
        var list = new SinglyLinkedList<Integer>();
        list.append(0);
        list.append(0);
        list.append(0);
        list.append(0);
        list.append(0);
        Assertions.assertEquals(0, BinaryUtils.binaryToDecimal(list));
    }

    @Test
    public void shouldReturn31ForBinaryAllOnes() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);
        list.append(1);
        Assertions.assertEquals(31, BinaryUtils.binaryToDecimal(list));
    }

    @Test
    public void shouldReturnOneForSingleBinaryOne() {
        var list = new SinglyLinkedList<Integer>();
        list.append(1);
        Assertions.assertEquals(1, BinaryUtils.binaryToDecimal(list));
    }

    @Test
    public void shouldReturnZeroForSingleBinaryZero() {
        var list = new SinglyLinkedList<Integer>();
        list.append(0);
        Assertions.assertEquals(0, BinaryUtils.binaryToDecimal(list));
    }

}