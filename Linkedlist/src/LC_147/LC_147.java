package LC_147;

import LC_203.LC_203;

public class LC_147 {
    private static class ListNode {
        private int val;
        private ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode insertionSortList(ListNode head) {

        // O(1)space
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        while (fast != null) {
            if (fast.val < slow.val) {
                ListNode nextNode = fast.next;
                slow.next = nextNode;
                fast.next = null;
                ListNode prev = dummyHead;
                ListNode cur = dummyHead.next;
                while (cur != null && fast.val > cur.val) {
                    prev = cur;
                    cur = cur.next;
                }
                fast.next = cur;
                prev.next = fast;
                fast = nextNode;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        LC_147 lc_147 = new LC_147();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        lc_147.insertionSortList(head);
    }
}
