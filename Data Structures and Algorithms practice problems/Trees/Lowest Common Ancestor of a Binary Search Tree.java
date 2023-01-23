/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
class Solution {

  //Sol. no. 1
      int small,larg;TreeNode lca;
      public void help(TreeNode root, TreeNode p, TreeNode q) {

         if(root==null)return ;

         if(small>root.val)
         help(root.right,p,q);

         else if(larg<root.val)
         help(root.left,p,q);

         else {
             lca=root;
             return;
         }
      }

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         
         small=Math.min(p.val,q.val);
         larg=Math.max(p.val,q.val);
         help(root,p,q);
         return lca;

     }
    

// Sol.no.2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       int small=Math.min(p.val,q.val);
       int larg=Math.max(p.val,q.val);
       while(root!=null){
           if(root.val>larg)
           root=root.left;
           else if(root.val<small)
           root=root.right;
           else return root;
       }
       return null;
    }
    





    // Sol. no. 3
    ArrayList <TreeNode>path1=new ArrayList<>();
    ArrayList <TreeNode>path2=new ArrayList<>();
    private TreeNode search(int value, TreeNode curRoot,int f) {
        if(curRoot==null)
        return null;

        if(f==1) path1.add(curRoot);
        else path2.add(curRoot);
        
        if(curRoot.val==value ){
            return curRoot;
        }

        if(value<curRoot.val)
        return search(value,curRoot.left,f);
        else  return search(value,curRoot.right,f);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(p.val,root,1);
        search(q.val,root,2);
        TreeNode lca=null;;
        for(int i=0;i<Math.min(path1.size(),path2.size());i++){        
            if(path1.get(i).val==path2.get(i).val)
            lca=path1.get(i);
            else break;
        }
        return lca;
    }
    
}
