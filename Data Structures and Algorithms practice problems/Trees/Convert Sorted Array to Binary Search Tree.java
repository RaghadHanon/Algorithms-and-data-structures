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

 //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class Solution {
    public TreeNode helper(int[] a, int left , int right) {
     if(left>right) return null;
     
     int mid= (left+right)/2;
     TreeNode root=new TreeNode(a[mid]);

     root.left=helper(a,left,mid-1);
     root.right=helper(a,mid+1,right);
     
     return root;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}
