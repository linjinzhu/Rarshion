package leetcode;

import java.util.Random;

/**
 * Author ： Martin
 * Date : 17/4/3
 * Description :
 * Version : 2.0
 */
public class LinkedListRandomNode {

    int len;
    ListNode head;
    Random random = new Random();

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        len = 0;
        ListNode cur = head;
        this.head = head;
        while( cur != null) {
            ++len;
            cur = cur.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int t = random.nextInt(len);
        ListNode cur = head;
        while (t > 0) {
            --t;
            cur = cur.next;
        }
        return cur.val;
    }
}
