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
        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return Integer.compare(l1.val, l2.val);
            }
        });
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            curr = curr.next;
        }
        return head.next;
    }
}
// @lc code=end

