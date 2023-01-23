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

 //https://leetcode.com/problems/balanced-binary-tree/
class Solution {

    int f=1;
    public int height(TreeNode root) {
    if(root==null)
        return -1;
    int ml=height(root.left);
    int mr=height(root.right);
    if(Math.abs(ml-mr)>1)f=0;
    return Math.max( ml, mr)+1 ;
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return f==1;   

    }
}
