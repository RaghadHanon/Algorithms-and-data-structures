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
 //https://leetcode.com/problems/rotate-list/
class Solution {
    public ListNode rotateRight(ListNode head, int r) {
         ListNode  temp=head;int sz=0;
         if(head==null||r==0)return head;
        while(temp!=null){
             temp=temp.next;
            sz++;
        }
    r%=sz;
    if(r!=0){
        ListNode fast=head,slow=head, newHead;int c=1;
        while(fast.next!=null){
            if(c<sz-r)
                slow=slow.next;
            fast=fast.next;
            c++;
        }
        newHead=slow.next;
        slow.next=(null);
        fast.next=(head);
        head=newHead;
        return head;
    }
    return head;

    }
}
