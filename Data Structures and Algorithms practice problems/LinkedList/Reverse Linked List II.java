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
 //https://leetcode.com/problems/reverse-linked-list-ii/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode=head,rightNode=head,prvOfLeft=null,nxtOfRight=null;
        ListNode cur,prv=null,nxt=head;

        if(left==right||head==null||head.next==null)
        return head;
        
        for(int i=1;i<left;i++){
            prvOfLeft=leftNode;
            leftNode=leftNode.next;
        }
        for(int i=1;i<right;i++){
            rightNode=rightNode.next;
            nxtOfRight=rightNode.next;
        }

        rightNode.next=null; cur=leftNode;
        while(nxt!=null){
            nxt=cur.next;
            cur.next=prv;
            prv=cur;
            cur=nxt;
        }

        leftNode.next=nxtOfRight;
        
        if(prvOfLeft!=null) prvOfLeft.next=rightNode;
        else   head=rightNode;

        return head;
    
    }
}
