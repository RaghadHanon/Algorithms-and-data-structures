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

 //https://leetcode.com/problems/sum-of-left-leaves/description/
class Solution {
    int x=0;
      public void sum(TreeNode root) {
     
        if(root!=null){

        if(root.left!=null&&root.left.left==null&&root.left.right==null)
        x+= root.left.val;

        sum(root.left);
        sum(root.right);
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
     sum(root);
     return x;
    }
}
