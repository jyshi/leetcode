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
        int k = nums1.length + nums2.length;
        if (k % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, k / 2) + findKth(nums1, nums2, 0, 0, k / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, k / 2 + 1);
        }
    }
    private double findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        } 
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        /
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }
        if (mid1 < mid2) {
            return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2);
        } else {
            return findKth(nums1, nums2, start1, start2 + k / 2, k - k / 2);
        }
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
