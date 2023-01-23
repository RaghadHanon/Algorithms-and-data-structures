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

 //https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] a=new int[2];
        if(head.next.next==null){
           a[0]=-1; a[1]=-1;
        return a;
        }
        ListNode prv=head,cur=head.next,nxt=head.next.next;
        int initial=-1,finall=-1,previous=-1,mn=1000000,mx=0,c=0;
        for(int i=2 ;nxt!=null;i++){
            if((prv.val<cur.val && nxt.val < cur.val) || (prv.val>cur.val && nxt.val > cur.val)){
                if(initial==-1)initial=i;
                finall=i;
                if(previous!=-1)
                mn=Math.min(mn,i-previous);
                previous=i;
                c++;
            }
            prv=cur;
            cur=cur.next;
            nxt=nxt.next;
        }
        if(c<2){
            a[0]=-1; a[1]=-1;
        }else {
        mx=finall-initial;
        a[0]=mn;a[1]=mx;
        }
        return a;

    
    }
}
