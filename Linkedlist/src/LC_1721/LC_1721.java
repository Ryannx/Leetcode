package LC_1721;

import Library.ListNode;

public class LC_1721 {
    public ListNode swapNodes(ListNode head, int k) {

        ListNode cur = head;
        ListNode firstNode = head;
        ListNode secondNode = head;
        int firstVal = 0;
        int secondVal = 0;
        int count = 1;
        while (cur != null) {
            if (count == k) {
                firstNode = cur;
                firstVal = cur.val;
                break;
            }
            cur = cur.next;
            count++;
        }
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        count--;
        if (count == 1) {
            return head;
        }
        cur = head;
        int step = 1;
        while (cur != null) {
            if (step == count - k + 1) {
                secondNode = cur;
                secondVal = cur.val;
                break;
            }
            cur = cur.next;
            step++;
        }

        firstNode.val = secondVal;
        secondNode.val = firstVal;
        return head;
    }

    public static void main(String[] args) {
        LC_1721 lc_1721 = new LC_1721();
        int[] input = {1,2,3,4,5};
        ListNode head = new ListNode();
        head = head.initial(input);
        lc_1721.swapNodes(head, 2);
    }
}
