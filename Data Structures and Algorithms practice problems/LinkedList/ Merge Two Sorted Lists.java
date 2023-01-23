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
 //https://leetcode.com/problems/merge-two-sorted-lists/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
       
        ListNode cur;
        if(list1.val>list2.val){cur=list2;list2=list2.next; }
        else{cur=list1; list1=list1.next;  }
        ListNode  Nhead=cur;
        while(list1!=null&&list2!=null){
            if(list1.val>list2.val){
               cur.next=list2;
                cur=list2;
                list2=list2.next;
            }else{
                cur.next=list1;
                cur=list1;
                list1=list1.next;
            }
        }
        cur.next=list1==null?list2:list1;
        return Nhead;
    }
}
