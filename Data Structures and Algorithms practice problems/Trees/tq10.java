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

 //https://leetcode.com/problems/increasing-order-search-tree/
class Solution {
    TreeNode nRoot=new TreeNode(-1),cur=nRoot;
    public void inOrder(TreeNode root) {
        if(root==null)
        return ;
        inOrder(root.left);
        cur.right=new TreeNode(root.val);
        cur=cur.right;
        inOrder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return nRoot.right;
    }
}
