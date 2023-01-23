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
 //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
class Solution {
    ArrayList<Integer>list=new ArrayList<>();
    public void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k-1);
    }
}
