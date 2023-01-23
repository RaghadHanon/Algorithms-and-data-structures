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
 //https://leetcode.com/problems/linked-list-cycle/
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
        return false;
    }
      ListNode fast = head, slow = head;
      while(fast!=null&&fast.next!=null){
          slow=slow.next;
          fast=fast.next.next;
          if(fast==slow)return true;

      }
      
      return false;

     
    }
    
}
