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

 //https://leetcode.com/problems/count-good-nodes-in-binary-tree/
class Solution {
    int x=0;
    public void Helper(TreeNode root, int max ) {
        if(max <= root.val){
            x++;
            max= root.val;
        }
        if(root.left!=null) Helper(root.left,max );
        if(root.right!=null) Helper(root.right,max );
    }
    public int goodNodes(TreeNode root) {
        Helper(root, root.val);
        return x;
    }
}
