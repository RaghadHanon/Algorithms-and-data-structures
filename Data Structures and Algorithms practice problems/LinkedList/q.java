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
 //https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
        return head;

        ListNode prvSlow=null, slow=head,fast=head;
        while(fast!=null&& fast.next!=null){
            if(fast.next.val!=fast.val){
                prvSlow=slow;
                slow=slow.next;
                fast=fast.next;
            }
            else{
                while(fast.next!=null&& fast.val==fast.next.val){
                    fast=fast.next;
                }
                if(prvSlow!=null)
                prvSlow.next=fast.next;
                else head=fast.next;
                slow=fast.next;
                fast.next=null;
                fast=slow;
            }
      

        }
      return head;
    }
}
