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
 //https://leetcode.com/problems/palindrome-linked-list/
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head, fast=head , prv,nxt;
        while(fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        prv=slow;
        slow=slow.next;
        prv.next=null;
        while(slow!=null){
            nxt=slow.next;
            slow.next=prv;
            prv=slow;
            slow=nxt;
        }
        slow=prv;
        fast=head;
        while(slow!=null){
            if(slow.val!=fast.val)
            return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
        
    }
}
