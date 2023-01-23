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

 //https://leetcode.com/problems/binary-tree-maximum-path-sum/description/?fbclid=IwAR0icl0uycVJiqdYT1agabzPTeSfvhqzhQsvPAnWyJAbSzoJyK9y9gN43U0
class Solution {
    int  max=-100000,GlMax=-100000;

    public int sum(TreeNode root) {
    int l=0,r=0;

     if(root.left!=null) l=sum(root.left);
     if(root.right!=null) r=sum(root.right);

      max=Math.max( root.val+Math.max(l,r) ,root.val);
      GlMax=Math.max(Math.max( root.val+l+r,max),GlMax);
      return max;
    }

    public int maxPathSum(TreeNode root) {
        sum(root);
        return GlMax;
    }
}
