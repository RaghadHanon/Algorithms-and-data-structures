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
 //https://leetcode.com/problems/reorder-list/
class Solution {

    public void reorderList(ListNode head) {
        //find second half
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //disconnect first half
        ListNode t = slow.next;
        slow.next=null;
        slow = t;
        
        //reverse second half
        ListNode second = null;
        while(slow != null) {
            ListNode temp = slow.next;
            slow.next = second;
            second =  slow;
            slow = temp;
        }
        
        //merge first and second halves
        ListNode first = head;
        while (second!=null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            second.next = temp1;
            first.next = second;
            first = temp1;
            second = temp2;
        }
    }
}
