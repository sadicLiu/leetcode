public class Code_019_RemoveNthNodeFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len < n)
            return null;
        if (len == n) {
            temp = head.next;
            head = null;
            return temp;
        }

        temp = head;
        for (int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }

        ListNode del = temp.next;
        temp.next = del.next;
        del = null;

        return head;
    }
}
