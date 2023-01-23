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
 //https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/?fbclid=IwAR1u7r5v_B5na-rzisvpyp-B9SkkeP3uUSh_88O81_icQUVySJwEOWhBVh0
class Solution {
    public void helper(TreeNode lroot, TreeNode rroot,int level) {
     
       if(lroot==null)return ;

       if(level%2==1){
           int tem=lroot.val;
           lroot.val=rroot.val;
           rroot.val=tem;
           
        }

        if(lroot.left!=null){
           helper(lroot.left,rroot.right,level+1);
           helper(lroot.right,rroot.left,level+1);
        }
       
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        helper(root.left,root.right,1);
        return root;
    }
}
