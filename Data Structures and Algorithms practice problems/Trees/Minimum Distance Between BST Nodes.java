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
 //https://leetcode.com/problems/minimum-distance-between-bst-nodes/
class Solution {
  Integer minDif=1000000,pre=null;
  public void inOrder(TreeNode root){
      if(root==null)
      return ;
      inOrder(root.left);
      if(pre!=null)
       minDif=Math.min(root.val-pre,minDif);
       pre=root.val;
      inOrder(root.right);
  }
  public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDif;
  }
}
