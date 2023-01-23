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
 //https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int size=0;
         ListNode cur=head;
        while(cur!=null) {
                cur=cur.next;
                size++;
         }
     int ind1=k;int ind2=size-k+1;
    if(ind1!=ind2){
        if(ind1>ind2){
            int t=ind1;ind1=ind2;ind2=t;
        }
      ListNode fast1=head,slow1=null,fast2=head,slow2=null,temp;
      for(int i=1;i< ind1;i++){
          slow1=fast1;
          fast1=fast1.next;
      }
      for(int i=1;i< ind2;i++){
            slow2=fast2;
            fast2=fast2.next;
      }
      if(slow1!=null) slow1.next=(fast2);
      slow2.next=(fast1);

      temp=fast1.next;
      fast1.next=(fast2.next);
      fast2.next=(temp);
      
      if(ind1==1)  head=fast2;

    }
return head;
    }
}
