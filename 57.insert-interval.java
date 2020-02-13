/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        int start = newInterval[0], end = newInterval[1];
        while (i < n && intervals[i][0] <= newInterval[1]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end

// 1 3 6 9

//  2  5