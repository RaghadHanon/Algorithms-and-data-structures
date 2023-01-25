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


 //https://leetcode.com/problems/next-greater-node-in-linked-list/
class Solution {
   public static int[] nextLargerNodes(ListNode head) {
       Stack <Integer> st=new Stack<>();
       ArrayList <Integer> list=new ArrayList<>();
       ListNode cur=head;
       while(cur!=null){
           list.add(cur.val);cur=cur.next;
        }
        int[] ans=new int[list.size()];

       for(int i=0;i<list.size();i++){
           if(st.isEmpty()){
               st.push(i);
               continue;
           }

           while(!st.empty()&& list.get(i)>list.get(st.peek())){
            ans[st.pop()]=list.get(i);   
           }

           st.push(i);
       }
        while(!st.empty()){
            ans[st.pop()]=0;   
        }
   return ans;

   }
}
