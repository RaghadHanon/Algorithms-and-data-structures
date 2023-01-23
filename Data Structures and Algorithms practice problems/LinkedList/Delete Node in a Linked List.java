/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //https://leetcode.com/problems/delete-node-in-a-linked-list/
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp=node.next.next;
        node.val=node.next.val;
        node.next=null;
        node.next=temp;
        
    }
}
