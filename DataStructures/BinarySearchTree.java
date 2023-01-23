import java.util.*;


public class BSTree<T extends Comparable<? super T>> {
    Node<T> root;
    int nodeCount;

    public BSTree() {
    }

    public BSTree(T value) {
        this.root = new Node<>(value);
        nodeCount++;
    }

    // Check if this binary tree is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Get the number of nodes in this binary tree
    public int size() {
        return nodeCount;
    }

    // insert a node in BST
    public boolean insert(T value){
        // Check if the value already exists in this binary tree, if it does ignore adding it
        if (contains(value))
            return false;

        // Otherwise add this element to the binary tree
        root =insert(value,root);
        nodeCount++;
        return true;

    }
    private Node<T> insert(T value , Node<T> curRoot){
        //tree is empty
        if(curRoot==null){
            curRoot=new Node<>(value);
            return curRoot;
        }
        //traverse the tree
        if(value.compareTo(curRoot.value)<0) //insert in the left subtree
            curRoot.left=insert(value,curRoot.left);
        else  if(value.compareTo(curRoot.value)>0) //insert in the right subtree
            curRoot.right=insert(value,curRoot.right);
        // return pointer
        return curRoot;

    }


    public boolean contains(T value) {
        return search(value)!=null;
    }
    public Node<T> search(T value) {
        return search(value,root);
    }

    private Node<T> search(T value, Node<T> curRoot) {
        if(curRoot==null||curRoot.value.equals(value ))
            return curRoot;

        if(value.compareTo(curRoot.value)<0)
            return search(value,curRoot.left);
        else   return search(value,curRoot.right);
    }
    //  method to find the leftmost node (which has the smallest value)
    public Node<T> minValue(Node <T> cur){
        while(cur!=null && cur.left!=null)
            cur=cur.left;
        return cur;
    }

    public boolean remove(T value){
        if(contains(value)){
            remove(root,value);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node<T> remove(Node<T> node, T value) {
        if(node==null)
            return node;
        int comp=value.compareTo(node.value);
        // Dig into left subtree, the value we're looking for is smaller than the current value
        if(comp<0)    node.left=remove(node.left,value);
            // Dig into right subtree, the value we're looking for is greater than the current value
        else if(comp>0)    node.right=remove(node.right,value);
            // Found the node we wish to remove
        else {
            // This is the case with only a right subtree or no subtree at all. In this situation just
            // swap the node we wish to remove with its right child.
            if(node.left==null)
                return node.right;

                // This is the case with only a left subtree or no subtree at all. In this situation just
                // swap the node we wish to remove with its left child.
            else if(node.right==null)
                return node.left;
                // When removing a node from a binary tree with two links the
                // successor of the node being removed can either be the largest
                // value in the left subtree or the smallest value in the right
                // subtree. In this implementation I have decided to find the
                // smallest value in the right subtree which can be found by
                // traversing as far left as possible in the right subtree.
            else {
                // Find the leftmost node in the right subtree
                Node<T>temp=minValue(node.right);
                // Swap the data
                node.value=temp.value;
                // Go into the right subtree and remove the leftmost node we
                // found and swapped data with. This prevents us from having
                // two nodes in our tree with the same value.
                node.right=remove(node.right,temp.value);
                // If instead we wanted to find the largest node in the left
                // subtree as opposed to the smallest node in the right subtree
                // here is what we would do:
                // Node tmp = findMax(node.left);
                // node.data = tmp.data;
                // node.left = remove(node.left, tmp.data);

            }

        }
        return node;

    }
    boolean f=true;
    public void sort(){
        while(f) {
            //  System.out.println(i);
            f=false;
            sort(root, null, null);
        }
    }

    private  void sort(Node<T> node,Node<T> upper,Node<T> lower) {
        if(node==null)
            return;
        if(lower!=null && node.value.compareTo(lower.value)<0){
            T tem=node.value;
            node.value=lower.value;
            lower.value=tem;f=true;
            //  inOrder();
        }
        if(upper!=null && node.value.compareTo(upper.value)>0){
            T tem=node.value;
            node.value=upper.value;
            upper.value=tem;f=true;
            //   inOrder();
        }

        sort(node.left,node,lower);
        sort(node.right,upper,node);

    }

    private Node<T> minValueRec(Node <T> cur){
        if(cur==null || cur.left==null)
            return cur;
        return minValueRec(cur.left);
    }
    //  method to find the rightmost node (which has the largest value)
    public Node<T> maxValue(Node<T> cur) {
        while(cur!=null && cur.right!=null)
            cur=cur.right;
        return cur;
    }
    private Node<T> maxValueRec(Node <T> cur){
        if(cur==null || cur.right==null)
            return cur;
        return maxValueRec(cur.right);
    }

    // Computes the height of the tree, O(n)
    public int height() {
        return height(root);
    }

    // Recursive helper method to compute the height of the tree
    private int height(Node<T> cur ) {
        if(cur==null)
            return 0;
        return Math.max( height(cur.left), height(cur.right))+1 ;
    }
    // method for inorder traversal of BST
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node<T> curRoot){
        if(curRoot!=null){
            inOrder(curRoot.left);
            System.out.print(curRoot.value+" ");
            inOrder(curRoot.right);
        }
    }

    // method for PreOrder traversal of BST
    public void PreOrder(){
        PreOrder(root);
        System.out.println();
    }
    private void PreOrder(Node<T> curRoot){
        if(curRoot!=null){
            System.out.print(curRoot.value+" ");
            PreOrder(curRoot.left);
            PreOrder(curRoot.right);
        }
    }
    // method for PostOrder traversal of BST
    public void PostOrder(){
        PostOrder(root);
        System.out.println();
    }
    private void PostOrder(Node<T> curRoot){
        if(curRoot!=null){
            PostOrder(curRoot.left);
            PostOrder(curRoot.right);
            System.out.print(curRoot.value+" ");

        }
    }



    //print level by level from left to right (up to down)
    public void LevelOrder(){
        bfs(root);
        System.out.println();
    }
    private void bfs(Node<T> root){
        Queue<Node<T>> q=new LinkedList<>();
        HashMap<T,Integer>level=new HashMap<>();
        if(root!=null) {
            q.add(root);
            level.put(root.value, 1);
        }
        while(!q.isEmpty()){
            Node<T> node=q.remove();
            System.out.print(node.value+" ");
            if(node.left!=null) {
                q.add(node.left);
                level.put((T) node.left.value, level.get(node.value) + 1);
            }
            if(node.right!=null) {
                q.add(node.right);
                level.put((T) node.right.value, level.get(node.value) + 1);
            }
        }
    }

    //print level by level from right to left (down to up)
    public void LevelOrder2(){
        bfs2(root);
        System.out.println();
    }
    private void bfs2(Node root){
        Queue<Node<T>> q=new LinkedList<>();
        Stack<T>st=new Stack<>();
        HashMap<T,Integer>level=new HashMap<>();
        if(root!=null) {
            q.add(root);
            level.put((T) root.value, 1);
        }
        while(!q.isEmpty()){
            Node<T>node=q.remove();
            st.push(node.value);
            if(node.left!=null) {
                q.add(node.left);
                level.put((T) node.left.value, level.get(node.value) + 1);
            }
            if(node.right!=null) {
                q.add(node.right);
                level.put((T) node.right.value, level.get(node.value) + 1);
            }
        }
        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
    //print level by level from left to right(down to up)
    public void LevelOrder3(){
        bfs3(root);
        System.out.println();
    }
    private void bfs3(Node root) {
        Queue<Node<T>> q = new LinkedList<>();
        Stack<T> st = new Stack<>();
        HashMap<T, Integer> level = new HashMap<>();
        if (root != null) {
            q.add(root);
            level.put((T) root.value, 1);
        }
        while (!q.isEmpty()) {
            Node<T> node = q.remove();
            st.push(node.value);
            if (node.right != null) {
                q.add(node.right);
                level.put((T) node.right.value, level.get(node.value) + 1);
            }
            if (node.left != null) {
                q.add(node.left);
                level.put((T) node.left.value, level.get(node.value) + 1);
            }

        }
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public void Morris(Node<T> node) {
        Node <T> curr, prev;
        if (node == null)
            return;
        curr = node;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.value + " ");
                curr = curr.right;
            } else {
                /* Find the previous (prev) of curr */
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;
                /* Make curr as right child of its prev */
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                /* fix the right child of prev*/

                else {
                    prev.right = null;
                    System.out.print(curr.value + " ");
                    curr = curr.right;
                }

            }

        }


    }

public class Node<T extends Comparable<? super T>> {
    T value;


    Node left;
    Node right;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  value+"" ;
    }
}

}

