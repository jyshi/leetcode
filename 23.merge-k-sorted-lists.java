eifjccinkkklvugllcggurhjjfjtiitfubjftigffuei
/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start == end - 1) {
            return merge2Lists(lists[start], lists[end]);
        } else {
            int mid = (start + end) / 2;
            ListNode firstHalf = mergeLists(lists, start, mid);
            ListNode secondHalf = mergeLists(lists, mid + 1, end);
            return merge2Lists(firstHalf, secondHalf);
        }
    }
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 == null) {
            curr.next = p2;
        } else {
            curr.next = p1;
        }
        return head.next;
    } 
}
// @lc code=end

//             p1 
// 1 -> 2 -> 4
//     cur


//     p2 
// 3 -> 5

// head -> 1 -> 2 -> 3
