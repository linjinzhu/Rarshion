package leetcode;

import java.io.UnsupportedEncodingException;

/**
 * Author ： Martin
 * Date : 17/4/4
 * Description :
 * Version : 2.0
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int flag = 0;
        ListNode res;
        ListNode tmp = new ListNode(0);
        res = tmp;

        l1 = reverse(l1);
        l2 = reverse(l2);

        while (l1 != null || l2 != null) {
            int a = (l1 == null ? 0 : l1.val);
            int b = (l2 == null ? 0 : l2.val);
            ListNode ss = new ListNode((a + b + flag) % 10);
            flag = (a + b + flag) / 10;
            tmp.next = ss;
            tmp = ss;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }

        if (flag == 1) {
            ListNode ss = new ListNode(1);
            tmp.next = ss;
        }

        return reverse(res.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode pCur = prev.next;

        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;
//
//        ListNode head = reverse(node1);
//
//        ListNode p = head;
//        while (p != null) {
//            System.out.print(p.val);
//            p = p.next;
//        }

        char chnStr = 'c';
        System.out.println("length of one Chinese character in gbk: " + chnStr);

    }
}
