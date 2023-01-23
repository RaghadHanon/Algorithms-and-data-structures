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

 //https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
class Solution {
     // 1.with data structure: 
     public boolean isCompleteTree1(TreeNode root) {
        //the last node should be null
        Queue <TreeNode > q=new LinkedList<>();
        boolean f=false;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                f=true;
            }
            else{
                if(f)return false;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;

    }
  
  //---------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  
    // 2. without data structure:
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        return 1+countNodes(root.left)+countNodes(root.right);

    }

     public boolean helper(TreeNode root,int n , int i) {
        if(root==null)return true;

        if((root.left!=null  && 2*i+1>=n )||(root.right!=null && 2*i+2>=n))
            return false;
        
        return helper(root.left ,n, 2*i+1) && helper(root.right ,n, 2*i+2);
    }
     public boolean isCompleteTree2(TreeNode root) {
        int n=countNodes(root);
        return helper (root,n,0); 
        
    }




}
