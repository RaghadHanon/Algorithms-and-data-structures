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

 //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
class Solution {
     List<List<Integer>>  list=new ArrayList<>();

    public void bfs(TreeNode root){
       Queue<TreeNode> q=new LinkedList<>();
       ArrayList<Integer>l=new ArrayList<>();
       int lev=1;
       if(root!=null)   q.add(root);
       
       while(!q.isEmpty()){
           int size=q.size();   

           for(int i=0;i<size;i++){
           TreeNode node=q.remove();
           l.add(node.val);
            if(node.left!=null)q.add(node.left);
            if(node.right!=null)q.add(node.right);
           
           }
           if(lev%2==0){
               Collections.reverse(l);
           }
           list.add(new ArrayList(l));
           l.clear();
           lev++;
       }

       
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root);
        
        return list;
    }
}
