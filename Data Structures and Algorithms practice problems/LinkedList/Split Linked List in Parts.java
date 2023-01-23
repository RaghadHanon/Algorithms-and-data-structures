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
 //https://leetcode.com/problems/split-linked-list-in-parts/
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur=head;int sz=0,rem,x=0; ListNode[] a=new ListNode[k];
        while(cur!=null){
            cur=cur.next;
            sz++;
        }
        cur=head;rem=sz%k;;
        for(int i=0;i<k;i++){
            a[i]=head;
            x=(rem-->0?1:0);
            for(int j=0;cur!=null&& j< sz/k +x -1 ;j++){
                cur=cur.next;
            }
            if(cur!=null){
                head=cur.next;
                cur.next=null;
            }
            else head=null;
            cur=head;
        }
        return a;
    }
}
