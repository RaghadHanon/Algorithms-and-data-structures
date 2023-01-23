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

 //https://leetcode.com/problems/binary-tree-right-side-view/
class Solution {
    
    ArrayList<Integer>list=new ArrayList<>();
    public void fun(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        if(root!=null)q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            TreeNode node=q.remove();
            if(i==0)list.add(node.val);
            if(node.right!=null)q.add(node.right);
            if(node.left!=null)q.add(node.left);
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        fun(root);
        return list;
    }
}
