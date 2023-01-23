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

 //https://leetcode.com/problems/diameter-of-binary-tree/
class Solution {
    int max;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return -1;
        int ml=maxDepth(root.left);
        int mr=maxDepth(root.right);
        max=Math.max(max,ml+mr+2);
        return Math.max( ml, mr)+1 ;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
}
