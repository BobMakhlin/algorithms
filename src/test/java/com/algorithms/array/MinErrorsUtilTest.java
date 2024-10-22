package com.algorithms.array;

import com.algorithms.amazon.MinErrorsUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinErrorsUtilTest {
    @Test
    void test0() {
        var x = 1;
        var y = 5;
        var expected = 6 * x + 2 * y;
        Assertions.assertEquals(expected, MinErrorsUtil.getMinErrors("001001", x, y).getSecond());
    }

    @Test
    void test1() {
        var x = 1;
        var y = 5;
        var expected = 2 * x + 2 * y;
        Assertions.assertEquals(expected, MinErrorsUtil.getMinErrors("0!1!0", x, y).getSecond());
    }

    @Test
    void test2() {
        var x = 1;
        var y = 5;
        var expected = 2 * y + 3 * x;
        Assertions.assertEquals(expected, MinErrorsUtil.getMinErrors("1!0!!!", x, y).getSecond());
    }

    @Test
    void test3() {
        var x = 5;
        var y = 3;
        var expected = 2 * x + 2 * y;
        Assertions.assertEquals(expected, MinErrorsUtil.getMinErrors("0!1!0", x, y).getSecond());
    }

    @Test
    void test4() {
        var x = 12222;
        var y = 5;
        var expected = 8 * y;
        Assertions.assertEquals(expected, MinErrorsUtil.getMinErrors("1!0!!!", x, y).getSecond());
    }

    @Test
    void test5() {
        var x = 12222;
        var y = 5;
        Assertions.assertEquals(0, MinErrorsUtil.getMinErrors("!!!!!!", x, y).getSecond());
    }
}