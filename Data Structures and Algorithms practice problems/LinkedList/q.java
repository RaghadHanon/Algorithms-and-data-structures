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

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/?fbclid=IwAR2CHmQP24AqHhluHV_pomxKGNQzmV7tsJfXpbi9DSel-1N8GJofl9G6V04
class Solution {
  
  List<List<Integer>>  list=new ArrayList<>();

    public void bfs(TreeNode root){
       Queue<TreeNode> q=new LinkedList<>();

       if(root!=null){
           q.add(root);
       }
       while(!q.isEmpty()){
           int size=q.size();    
           ArrayList<Integer>l=new ArrayList<>();
           for(int i=0;i<size;i++){
           TreeNode node=q.remove();
           l.add(node.val);
           if(node.left!=null)q.add(node.left);
           if(node.right!=null)q.add(node.right);
           }
           list.add(l);
       }

       
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        
        return list;
    }
}
