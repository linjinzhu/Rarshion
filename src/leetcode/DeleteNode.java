package leetcode;

/**
 * Created by user on 2016/8/5.
 */
public class DeleteNode {

    public void DeleteNode(ListNode node){

        if(node == null)
            return;

        node.val = node.next.val;
        node.next = node.next.next;
    }

}
