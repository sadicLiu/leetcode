public class Code_021_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode node1 = l1, node2 = l2;
        ListNode res = null;
        ListNode temp = null;
        while (node1 != null && node2 != null) {
            ListNode min = node1.val <= node2.val ? node1 : node2;
            if (res == null) {
                res = min;
                temp = res;
            } else {
                temp.next = min;
                temp = temp.next;
            }
            if (min == node1) node1 = node1.next;
            else node2 = node2.next;
        }
        if (node1 != null)  temp.next = node1;
        if (node2 != null)  temp.next = node2;

        return res;
    }
}
