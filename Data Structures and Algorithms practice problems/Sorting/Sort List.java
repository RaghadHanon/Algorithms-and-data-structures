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

 //https://leetcode.com/problems/sort-list/
class Solution {
    public ListNode middle(ListNode head) {
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head) {
        if(head!=null&&head.next!=null){
        ListNode mid=middle(head);
        ListNode left=head;
        ListNode right =mid.next;
        mid.next=null;

        left=mergeSort(left);
        right=mergeSort(right);

        return merge(left,right);
        }
        return head;
    }
     public ListNode merge(ListNode left,ListNode right) {
         if(left==null)return right;
         if(right==null)return left;
        ListNode cur,nHead;
        if(left.val<right.val){
            cur=left;
            left=left.next;
        }else {
            cur=right;
            right=right.next;
        }
        nHead=cur;
        while(left!=null||right!=null){
            if(right==null|| (left!=null&&left.val<=right.val )){
                cur.next=left;
                cur=cur.next;
                left=left.next;
            }
            else if(left==null || (right!=null&&right.val<=left.val )){
                cur.next=right;
                cur=cur.next;
                right=right.next;
            }

        }
        return nHead;
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
