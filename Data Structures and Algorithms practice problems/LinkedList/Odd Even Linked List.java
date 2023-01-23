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
 //https://leetcode.com/problems/odd-even-linked-list/
class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
        return head;
        ListNode evenHead =head.next,even=evenHead, odd=head;
        while(even!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;

        
    }
}
