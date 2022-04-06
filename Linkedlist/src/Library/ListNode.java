package Library;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode initial(int[] input) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < input.length; i++) {
            cur.val = input[i];
            if (i < input.length - 1) {
                cur.next = new ListNode();
            }
            cur = cur.next;
        }

        return head;
    }
}
