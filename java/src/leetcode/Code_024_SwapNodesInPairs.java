class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Code_024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = head;
        ListNode right = head.next;
        ListNode next = right.next;
        ListNode prev = null;
        head = right;
        while (left != null) {
            left.next = next;
            right.next = left;

            if (prev != null)
                prev.next = right;
            prev = left;

            left = next;
            if (left == null || left.next == null)
                break;
            else {
                right = left.next;
                next = right.next;
            }
        }

        return head;
    }
}
