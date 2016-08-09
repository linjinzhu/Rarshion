package leetcode;

/**
 * Created by user on 2016/8/6.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){

        ListNode pre = null,cur = head,next = null;

        while(null != cur){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
