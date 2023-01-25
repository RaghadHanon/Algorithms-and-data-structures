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

 //https://leetcode.com/problems/reverse-nodes-in-k-group/
class Solution {
    
    public ListNode reverseKGroup(ListNode head,int k) {
       ListNode cur=head, prv=null,nxt=cur;
       for(int i=1;i<=k;i++){
          if(cur==null)return head;
          cur=cur.next;
       }
       cur=head;
       for(int i=1;i<=k;i++){
           nxt=nxt.next;
           cur.next=prv;
           prv=cur;
           cur=nxt;
       }
       head.next=reverseKGroup(cur,k);
       return prv;


    }
}


