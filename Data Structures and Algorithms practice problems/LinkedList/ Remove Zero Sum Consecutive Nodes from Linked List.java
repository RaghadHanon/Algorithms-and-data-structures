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
 //https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if(head==null)return head;
        ListNode prvHead=new ListNode(-1,head),prv=prvHead,cur;

        while(prv!=null){
            int sum=0;
            cur=prv.next;
            while(cur!=null){
                sum+=cur.val;
                if(sum==0)
                prv.next=cur.next;
                cur=cur.next;
            }
            prv=prv.next;
        }
        return prvHead.next;
    }
}
