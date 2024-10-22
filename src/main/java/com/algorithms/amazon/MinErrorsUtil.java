package com.algorithms.amazon;

import org.apache.commons.math3.util.Pair;

import java.util.HashMap;

public class MinErrorsUtil {
    /**
     * a string "0!1!01"
     * replace ! with 1 or 0 in order to have the least amount of errors.
     *
     * @param x 0..1 -> value of error (in the entire string)
     * @param y 1..0 -> value of error (in the entire string)
     */
    public static Pair<String, Integer> getMinErrors(String errorString, int x, int y) {
        var chars = errorString.toCharArray();

        var map0 = new HashMap<Integer, Integer>();
        var map1 = new HashMap<Integer, Integer>();
        var count0 = 0;
        var count1 = 0;
        var errorsCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                count0++;
            } else if (chars[i] == '1') {
                count1++;
            }
            map0.put(i, count0);
            map1.put(i, count1);
        }

        var added1Count = 0;
        var added0Count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                // 01 = x
                var totalCountOf1 = map1.get(chars.length - 1);
                var countOf1SoFar = map1.get(i);
                var countOf1AfterCurrentChar = totalCountOf1 - countOf1SoFar;
                errorsCount += countOf1AfterCurrentChar * x;
            } else if (chars[i] == '1') {
                // 10 = y
                var totalCountOf0 = map0.get(chars.length - 1);
                var countOf0SoFar = map0.get(i);
                var countOf0AfterCurrentChar = totalCountOf0 - countOf0SoFar;
                errorsCount += countOf0AfterCurrentChar * y;
            } else if (chars[i] == '!') {
                // what if we insert '0'
                var countOf1BeforeCurrentChar = map1.get(i) + added1Count;
                var totalCountOf1 = map1.get(chars.length - 1);
                var countOf1SoFar = map1.get(i);
                var countOf1AfterCurrentChar = totalCountOf1 - countOf1SoFar;
                var errorsIntroducedBy0 = countOf1BeforeCurrentChar * y // 1..0
                                          + countOf1AfterCurrentChar * x; // 0..1
                // what if we insert '1'
                var countOf0BeforeCurrentChar = map0.get(i) + added0Count;
                var totalCountOf0 = map0.get(chars.length - 1);
                var countOf0SoFar = map0.get(i);
                var countOf0AfterCurrentChar = totalCountOf0 - countOf0SoFar;
                var errorsIntroducedBy1 = countOf0BeforeCurrentChar * x // 0..1
                                          + countOf0AfterCurrentChar * y; // 1..0

                if (errorsIntroducedBy0 < errorsIntroducedBy1) {
                    added0Count++;
                    errorsCount += errorsIntroducedBy0;
                    chars[i] = '0';
                } else {
                    added1Count++;
                    errorsCount += errorsIntroducedBy1;
                    chars[i] = '1';
                }
            }
        }

        return new Pair<>(new String(chars), errorsCount);
    }

//    private static int calcErrors(char[] chars, int xValue, int yValue) {
//        var xErrors = 0;
//        var yErrors = 0;
//
//        for (int i = 0; i < chars.length; i++) {
//            for (int j = i; j < chars.length; j++) {
//                if (chars[i] == '0' && chars[j] == '1') {
//                    xErrors++;
//                } else if (chars[i] == '1' && chars[j] == '0') {
//                    yErrors++;
//                }
//            }
//        }
//
//        return xErrors * xValue + yErrors * yValue;
//    }
}
