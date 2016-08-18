package leetcode;

/**
 * Created by rarshion on 16/8/10.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

       if(head == null || head.next == null)
           return false;

        ListNode p = head, q = head;

        while(p.next != null && p.next.next != null){
            q = q.next;
            p = p.next.next;
            if(q == p)
                return true;
        }

        return false;
    }
}
