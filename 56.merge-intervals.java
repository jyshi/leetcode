/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         return Integer.compare(a[0], b[0]);
        //     }
        // });
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int new_start = intervals[i][0];
            int new_end = intervals[i][1];
            // merge
            if (new_start <= end) {
                end = Math.max(end, new_end);
            // don't merge
            } else {
                // add previous interval
                result.add(new int[]{start, end});
                start = new_start;
                end = new_end;
            }
        }
        result.add(new int[]{start, end});
        
        return result.toArray(new int[result.size()][2]);
    }
}
// @lc code=end

// 1  3
//  2   6
//       8 10
//             15 18