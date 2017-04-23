package leetcode;

/**
 * Created by user on 2016/8/9.
 */
public class LinkedListTest {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode cur = head, next = head.next;

        while(cur != null){

            if(next.val == cur.val)
                cur.next = next.next;
            else
                cur = next;

            next = next.next;
        }

        return head;
    }
}
