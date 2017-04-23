package leetcode;

/**
 * Created by rarshion on 16/8/23.
 */
public class ReorderList {

    private static ListNode reverseList(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    private static ListNode findMiddleNode(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        ListNode middleNode = findMiddleNode(head);
        ListNode tailHead = reverseList(middleNode.next);
        middleNode.next = null;

        int index = 0;
        ListNode dummy = new ListNode(0);

        while(head != null && tailHead != null){
            if (index%2 == 0) {
                dummy.next = head;
                head = head.next;
            } else {
                dummy.next = tailHead;
                tailHead = tailHead.next;
            }
            dummy = dummy.next;
            index++;
        }

        if(head != null)
            dummy.next = head;

        if(tailHead != null)
            dummy.next = tailHead;

    }

    public static void main(String[] args){

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(findMiddleNode(n1).val);

        reorderList(n1);

    }


}
