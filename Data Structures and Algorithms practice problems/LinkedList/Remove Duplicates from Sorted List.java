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
 //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            while(cur!=null&&cur.next!=null&&cur.val==cur.next.val){
              
                    ListNode temp=cur.next.next;
                    cur.next.next=null;
                    cur.next=temp;
                

            }
            cur=cur.next;
        }
        return head;
    }
}
