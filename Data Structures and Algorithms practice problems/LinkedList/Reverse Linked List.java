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
 //https://leetcode.com/problems/reverse-linked-list/description/
class Solution {
   // Iterative
    public ListNode reverseList(ListNode head) {
        
        ListNode cur=head,prv=null,nxt;
         while(cur!=null){
            nxt=cur.next;
            cur.next=(prv);
            prv=cur;
            cur=nxt;
          }
        return prv;
          
    }
    
    // recursive
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        return head;
        ListNode res=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return res;
          
    }
}
