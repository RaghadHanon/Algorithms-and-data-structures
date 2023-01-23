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

 //https://leetcode.com/problems/binary-tree-paths/description/?fbclid=IwAR0bP8u1fxGsAboBsgkCPSJT5rCHIHlrxPTyvX9nEfztP_h-IIm1Wkx9w4o
class Solution {
    ArrayList <String > list=new ArrayList<>() ;
    public void path(TreeNode root, String s) {
  
        if(root.left==null&&root.right==null){
            list.add(s+Integer.toString(root.val));
            return ;
        }
        s+=Integer.toString(root.val)+"->";
        if(root.left!=null)path(root.left,s);
        if(root.right!=null)path(root.right,s);
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        path(root,"");
        return list;
    }
}
