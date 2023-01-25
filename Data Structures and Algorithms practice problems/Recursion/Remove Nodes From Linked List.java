/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 //https://leetcode.com/problems/remove-nodes-from-linked-list/
class Solution {
  
  //Sol. no. 1
   int mxprv=0;
   public ListNode fun(ListNode head) {
        if(head.next!=null){
            head.next=fun(head.next);
        }
        mxprv=Math.max(mxprv,head.val);
        if(mxprv>head.val)
        return head.next;
        else return head;
    }
    public ListNode removeNodes(ListNode head) {
        return fun(head);
    }


//------------------------------------------------------------------------------------------------------------------------
    
  //Sol. no. 2
    public int modifyVal(ListNode head) {
        int v=0;
        if(head.next!=null){
            v=modifyVal(head.next);
            if(v>head.val) head.val=-1;
        }
        return Math.max(head.val,v);
    }
    public ListNode removeNodes(ListNode head) {
        modifyVal( head);
        ListNode dummy=new ListNode(-1,head),prv=dummy,cur=dummy;
        while(prv!=null){
            cur=cur.next;
            while(cur!=null&&cur.val==-1){
                cur=cur.next;
            }
            prv.next=cur;
            prv=cur;
        }
        return dummy.next;

    }
    
}
