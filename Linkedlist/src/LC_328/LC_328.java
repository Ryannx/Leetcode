package LC_328;

public class LC_328 {

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

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode evenHead = new ListNode();
        ListNode evenHeadPointer = evenHead;
        ListNode cur = head;
        ListNode prev = new ListNode(-1, head);
        int count = 1;
        while (cur != null) {
            if (count % 2 != 0) {
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                evenHeadPointer.next = cur;
                evenHeadPointer = cur;
                cur.next = null;
                cur = prev.next;
            }
            count++;
        }

        prev.next = evenHead.next;
        return head;
    }

    public static void main(String[] args) {
        LC_328 lc_328 = new LC_328();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        lc_328.oddEvenList(head);
    }
}
