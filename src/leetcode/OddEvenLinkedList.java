package leetcode;

import java.util.Date;

/**
 * Created by rarshion on 16/8/22.
 */
public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode oddHead = head, eventHead = head.next;
        ListNode pOdd = oddHead, pEvent = eventHead;

        while(pOdd.next != null && pEvent.next != null){
            pOdd.next = pEvent.next;
            pOdd = pOdd.next;

            pEvent.next = pOdd.next;
            pEvent = pEvent.next;
        }

        pOdd.next = eventHead;
        return oddHead;
    }

    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;

        //ArrayUtils.printList(p1);
        ArrayUtils.printList(oddEvenList(p1));

    }

}
