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

 //https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
    public boolean check(TreeNode root, long left, long right) {
        if(root==null)
        return true ;

        if(root.val <= left || root.val >= right)
        return false;

        return check(root.left, left, root.val) && check(root.right, root.val, right);
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,(long) Integer.MIN_VALUE -1 ,(long) Integer.MAX_VALUE+1 );
    }
}
