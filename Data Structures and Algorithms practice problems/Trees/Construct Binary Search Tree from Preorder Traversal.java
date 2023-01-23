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

  //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/ 

class Solution {
// Sol. no. 1
    int i=0;
    public TreeNode add(int[] arr,int bound){
      if(i==arr.length|| arr[i]>bound)return null;

      TreeNode root=new TreeNode (arr[i++]);
      root.left=add(arr,root.val);
      root.right=add(arr,bound);

      return root;

    }
    
    public TreeNode bstFromPreorder1(int[] preorder) {
        return add(preorder , Integer.MAX_VALUE);
    }
// Sol. no. 2
public TreeNode add(TreeNode root,int val){
        if(root==null)
            return root= new TreeNode(val);
        
        if(root.val>val) root.left=add(root.left,val);
        else  root.right=add(root.right,val);

        return root;

    }
    public TreeNode bstFromPreorder2(int[] preorder) {
        TreeNode root =null;
        for(int node : preorder){
            root=add(root ,node);
        }
        return root;
    }
    
}
