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

 //https://leetcode.com/problems/count-complete-tree-nodes/description/
class Solution {
    public int countNodes(TreeNode root) {
        int rDepth=rightDepth(root);
        int lDepth=leftDepth(root);
        if(rDepth==lDepth)
          return (1<<rDepth)-1;

        return 1+ countNodes(root.left)+countNodes(root.right);


    }
    public int rightDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            depth++;
            node=node.right;
        }
        return depth;
    }
     public int leftDepth(TreeNode node){
        int depth=0;
        while(node!=null){
            depth++;
            node=node.left;
        }
        return depth;
    }
}
