/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//find the meeting point and if it exist make the two paths equals 
class Solution {
  
public void meetingPointAndModify(TreeNode head1,TreeNode head2 ){
    int size1=0,size2=0,flag=0,diff=0;
    TreeNode cur1=head1,cur2=head2,tail=head1,newHead,newTail;
    while(cur1!=null){
        cur1=cur1.getNext();
        size1++;
        tail=cur1;
    }
    while(cur2!=null){
        cur2=cur2.getNext();
        size2++;
    }
    cur1=head1;cur2=head2;
    if(size1>size2){
        newHead=cur1;
        for(int i=0;i<size1-size2;i++){
            cur1=cur1.getNext();
        }
    }else {
        newHead=cur2;
        for(int i=0;i<size2-size1;i++) {
            cur2 = cur2.getNext();
        }
    }
    while(cur1!=null){
        if(cur1==cur2)
            flag=1 ;
        cur1=cur1.getNext();
        cur2 = cur2.getNext();
    }
    if(flag==1){
        newTail=newHead;
        diff=Math.abs(size1-size2);
        for(int i=1;i<diff;i++){
            newTail=newTail.getNext();
        }
        head1=newTail.getNext();
        newTail.setNext(null);
        tail.setNext(newHead);

    }
}

}
