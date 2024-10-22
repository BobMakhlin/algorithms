package com.algorithms.amazon;

import java.util.HashSet;
import java.util.List;

public class WatchHistoryUtil {
    /*
    watch history represents the history of days, where every integer is an id of tv series
    we need to get the min range where both series1 and series2 present, avoiding dups.
    1, 3, 2, 1, 4
    [2, 1] -> 2 (the response)
     */
    public int getWatchHistory(List<Integer> watch_history, int series1, int series2) {
//        List<Integer> watch_history = List.of(1, 3, 2, 1, 4);
//        int series1 = 1;
//        int series2 = 1;

        var lastSeenSeries1 = -1;
        var lastSeenSeries2 = -1;
        var minLength = Integer.MAX_VALUE;

        for (var i = 0; i < watch_history.size(); i++) {
            var cur = watch_history.get(i);
            if (cur.equals(series1)) {
                lastSeenSeries1 = i;
            }
            if (cur.equals(series2)) {
                lastSeenSeries2 = i;
            }

            if (lastSeenSeries2 != -1 && lastSeenSeries2 != -1) {
                int start = Math.min(lastSeenSeries1, lastSeenSeries2);
                int end = Math.max(lastSeenSeries1, lastSeenSeries2);
                List<Integer> sublist = watch_history.subList(start, end + 1);
                var set = new HashSet<Integer>(sublist);

                if (set.size() < minLength) {
                    minLength = set.size();
                }
            }
        }
        return minLength;
    }
}
