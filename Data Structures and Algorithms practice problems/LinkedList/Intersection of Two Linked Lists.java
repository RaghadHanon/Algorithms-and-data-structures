/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
          int size1=0,size2=0;
        ListNode cur1=head1,cur2=head2;
        while(cur1!=null){
            cur1=cur1.next;
            size1++;
        }
        while(cur2!=null){
            cur2=cur2.next;
            size2++;
        }
        cur1=head1;cur2=head2;
        if(size1>size2){
            for(int i=0;i<size1-size2;i++){
                cur1=cur1.next;
            }
        }else {
            for(int i=0;i<size2-size1;i++) {
                cur2 = cur2.next;
            }
        }
        while(cur1!=null){
            if(cur1==cur2)
                return cur1;
            cur1=cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}
