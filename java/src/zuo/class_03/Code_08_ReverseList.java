package zuo.class_03;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

public class Code_08_ReverseList {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, null);
        ListNode node3 = new ListNode(3, null);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        printList(head);
        printList(reverseList(head));
    }
}
