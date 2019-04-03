public class Code_002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
    * 可以通过
    * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int curSum = 0;
        int count = 0;
        ListNode res = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            curSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + count;
            count = 0;
            if (curSum >= 10) {
                curSum = curSum % 10;
                count = 1;
            }

            ListNode node = new ListNode(curSum);
            if (res == null) {
                res = node;
                temp = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (count == 1) {
            temp.next = new ListNode(1);
        }

        return res;
    }

    /*
    * 超时
    * */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int num1 = convertToNumber1(l1);
        int num2 = convertToNumber1(l2);
        int res = num1 + num2;

        ListNode head = null;
        while (res / 10 != 0) {
            if (head == null) {
                head = new ListNode(res % 10);
            } else {
                head.next = new ListNode(res % 10);
            }
            res /= 10;
        }

        return head;
    }

    public static int convertToNumber1(ListNode node) {
        if (node == null)
            return 0;

        int res = 0;
        int base = 1;
        while (node != null) {
            res += node.val * base;
            base *= 10;
        }
        return res;
    }
}
