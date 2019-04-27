package zuo.class_03;

/*
 * 判断一个链表是否是回文结构
 * */
public class Code_11_PalindromeList {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        if (head.next == null)
            return true;

        // 找到链表的中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reverseList(slow);
        slow = head;
        ListNode last = fast;
        while (slow != null) {
            if (slow.value != fast.value)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        reverseList(last);
        return true;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        ListNode node1 = new ListNode(0, null);
//        ListNode node2 = new ListNode(1, null);
//        ListNode node3 = new ListNode(0, null);
//        ListNode node4 = new ListNode(0, null);

        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        printList(head);
//        printList(reverseList(head));
//        isPalindrome(head);
        System.out.println(isPalindrome(head));
//        printList(head);
    }

}
