package com.algorithms.array;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LengthOfLongestSubstringProblem {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        //"andvxdryuo"
        //when the second d is encountered, the previous substring becomes "and" -> everything before that d and 'd' itself
        //those chars should be removed from the set, since they are no longer considered!

        while (right < n) {
            if (set.contains(s.charAt(right))) {
                // If duplicate is found, we will move the left pointer,
                // removing everything related to the previous substring.
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
        }

        return maxLength;
    }

}
