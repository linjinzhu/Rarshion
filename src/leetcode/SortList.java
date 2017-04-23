package leetcode;

/**
 * Created by rarshion on 16/9/26.
 */
public class SortList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode merge(ListNode list1, ListNode list2) {

        if( list1 == null && list2 != null) {
            return list2;
        }

        if (list1 != null && list2 == null ) {
            return list1;
        }

        ListNode head = new ListNode(-999);
        ListNode p = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1 != null) {
           p.next = list1;
        }

        if (list2 != null) {
            p.next = list2;
        }

        return head.next;
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;

        sortList(list2);
        sortList(head);

        return merge(head, list2);
    }

}
