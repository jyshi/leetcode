/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findKth(nums2, nums2.length);
        } else if (nums2 == null || nums2.length == 0) {
            return findKth(nums1, nums1.length);
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        // nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i - 1 >= 0 && i - 1 < m && j >= 0 && j < n && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else if (j - 1 >= 0 && j - 1 < n && i >= 0 && i < m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                int max_left;
                if (i == 0) {
                    max_left = nums2[j - 1];
                } else if (j == 0) {
                    max_left = nums1[i - 1];
                } else {
                    max_left = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 != 0) {
                    return max_left;
                }
                int min_right;
                if (i == m) {
                    min_right = nums2[j];
                } else if (j == n) {
                    min_right = nums1[i];
                } else {
                    min_right = Math.min(nums1[i], nums2[j]);
                }
                return (max_left + min_right) / 2.0;
            }
        }
        return 0;
    }
    private double findKth(int[] nums, int k) {
        if (k % 2 == 0) {
            return (nums[k / 2 - 1] + nums[k / 2]) / 2.0;
        } else {
            return nums[k / 2];
        }
    }

}
// @lc code=end
