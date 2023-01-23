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

 //https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
   

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;ListNode cur=head,temp;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        cur=head;
        if(size-n==0){
            head=head.next;
            cur.next=null;
        }
        else {
        for(int i=1;i< size-n;i++){
            cur=cur.next;
        }
        if(n==1)cur.next=null;
        else{
        temp=cur.next.next;
        cur.next.next=null;
        cur.next=temp;
        }
        }
        return head;


    }
}
