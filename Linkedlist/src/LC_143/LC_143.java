package LC_143;

import Library.ListNode;

public class LC_143 {

    public void reorderList(ListNode head) {

        // get the middle of linkedList;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second part of linkedlist
        ListNode secondDummyHead = new ListNode();
        ListNode cur = slow;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = secondDummyHead.next;
            secondDummyHead.next = cur;
            cur = temp;
        }

        // merge
        ListNode dummyHead = new ListNode();
        ListNode dyCur = dummyHead;
        ListNode cur1 = head;
        ListNode cur2 = secondDummyHead.next;
        while (cur1 != null && cur2 != null) {
            if (cur1 != slow) {
                dyCur.next = cur1;
                dyCur = dyCur.next;
                cur1 = cur1.next;
            }
            dyCur.next = cur2;
            dyCur = dyCur.next;
            cur2 = cur2.next;
        }
        if (cur1 != null && cur1 != slow) {
            dyCur.next = cur1;
        }

        head = dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LC_143 lc_143 = new LC_143();
        lc_143.reorderList(head);
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
