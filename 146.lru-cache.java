/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    int size;
    int capacity;
    Map<Integer, ListNode> map;
    ListNode dummyHead;
    ListNode dummyTail;
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new ListNode(0, 0);
        dummyTail = new ListNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        ListNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
        } else {
            node = new ListNode(key, value);
            if (size < capacity) {
                size++;
            // max capacity
            } else {
                removeTail();
            }
            map.put(key, node);

        }
        moveToHead(node);

    }

    private void moveToHead(ListNode node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        node.next = dummyHead.next;
        node.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    private void removeTail() {
        ListNode tail = dummyTail.prev;
        tail.prev.next = dummyTail;
        dummyTail.prev = tail.prev;
        map.remove(tail.key);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
