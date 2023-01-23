/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //https://leetcode.com/problems/linked-list-cycle-ii/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
        return null;
    }
      ListNode fast = head, slow = head;
      while(fast!=null&&fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if(fast==slow)break;

      }
      if(fast==slow){
         slow=head;
           while(slow!=fast){
             slow=slow.next;
            fast=fast.next;
            }
            return fast;
      }
      return (null);

     
    
    }
}
