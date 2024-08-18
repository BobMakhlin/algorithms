package com.algorithms.hashtable;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {
    private ListUtils() {
    }

    public static <E> boolean itemInCommon(List<E> a, List<E> b) {
        var set = new HashSet<>(a);
        for (var item : b) {
            if (set.contains(item)) {
                return true;
            }
        }
        return false;
    }

    public static <E> List<E> findDups(List<E> lst) {
        var dups = new HashSet<E>();
        var set = new HashSet<E>();
        for (var item : lst) {
            if (!set.add(item)) {
                dups.add(item);
            }
        }
        return new ArrayList<>(dups);
    }

    public static Character firstNonRepeatingChar(String str) {
        var set = new HashSet<Character>();
        var linkedHashSet = new LinkedHashSet<Character>(); // HashSet that maintains the order.
        for (var c : str.toCharArray()) {
            if (set.add(c)) {
                linkedHashSet.add(c);
            } else {
                linkedHashSet.remove(c);
            }
        }
        var it = linkedHashSet.iterator();
        return it.hasNext() ? it.next() : null;
    }

    public static List<List<String>> groupAnagrams(List<String> strings) {
        var map = new HashMap<String, List<String>>();
        for (var str : strings) {
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            var sorted = new String(charArray);

            var anagramList = new ArrayList<String>();
            anagramList.add(str);

            map.merge(sorted, anagramList, (oldAnagramList, newValue) -> {
                oldAnagramList.add(str);
                return oldAnagramList;
            });
        }
        return map.values().stream().toList();
    }

    public static List<Integer> twoSum(List<Integer> list, Integer target) {
        var indexByValueMap = new HashMap<Integer, Integer>();
        for (var i = 0; i < list.size(); i++) {
            indexByValueMap.put(list.get(i), i);
        }
        for (var i = 0; i < list.size(); i++) {
            var item = list.get(i);
            var operand2 = target - item;
            var index = indexByValueMap.get(operand2);
            if (index != null) {
                return List.of(i, index);
            }
        }
        return List.of();
    }

    public static List<Integer> subarraySum(List<Integer> nums, Integer target) {
        var sum = 0;
        var indexBySumMap = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            indexBySumMap.put(sum, i);
            if (sum == target) {
                return List.of(0, i);
            }
            var diff = sum - target;
            var startIndex = indexBySumMap.get(diff);
            if (startIndex != null) {
                return List.of(startIndex + 1, i);
            }
        }
        return List.of();
    }

    public static <E> List<E> removeDups(List<E> list) {
        return new HashSet<>(list).stream().toList();
    }

    public static boolean hasUniqueChars(String str) {
        var s = new HashSet<Character>();
        for (var c : str.toCharArray()) {
            if (!s.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        var res = new ArrayList<int[]>();
        var set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        for (var item : arr2) {
            var diff = target - item;
            if (set.contains(diff)) {
                res.add(new int[]{diff, item});
            }
        }
        return res;
    }

    public static int longestConsecutiveSequence(List<Integer> list) {
        var s = new HashSet<>(list);
        int maxCount = 0;
        int count = 0;
        for (var item : list) {
            count++;

            var prev = item - 1;
            while (s.contains(prev)) {
                count++;
                prev--;
            }

            if (count > maxCount) {
                maxCount = count;
            }
            count = 0;
        }
        return maxCount;
    }
}
