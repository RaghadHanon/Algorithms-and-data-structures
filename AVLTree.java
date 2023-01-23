import java.util.*;

public class AVLTree<T extends Comparable<? super T>> {
    Node<T> root;
    int nodeCount;

    public AVLTree() {
    }

    public AVLTree(T value) {
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

        update(curRoot);
        return balance(curRoot);

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
            if(node.left==null)
                return node.right;
            else if(node.right==null)
                return node.left;
            else {
                if(node.right.height>node.left.height) {
                    Node<T> temp = minValue(node.right);
                    node.value = temp.value;
                    node.right = remove(node.right, temp.value);
                }else {
                    Node<T> temp = maxValue(node.left);
                    node.value = temp.value;
                    node.left = remove(node.left, temp.value);
                }
            }
        }
        update(node);
        return balance(node);

    }

    // Update a node's height and balance factor.
    public void update (Node<T> node){
        int leftHeight = (node.left==null?-1 : node.left.height);
        int rightHeight = (node.right==null?-1 : node.right.height);
        // Update balance factor.
        node.bf =leftHeight-rightHeight;
        // Update this node's height.
        node.height=1+Math.max(leftHeight,rightHeight);

    }
    // Re-balance a node if its balance factor is +2 or -2.
    private Node<T> balance (Node<T> node){
        // Left heavy subtree.
        if(node.bf ==2){
            if(node.left.bf>0)
              return leftLeftCase(node);
            else return leftRightCase(node);
        }
        // Right heavy subtree needs balancing.
        else if(node.bf==-2){
            if(node.right.bf<0)
                return rigthRightCase(node);
            else return rightLeftCase(node);
        }
        // Node either has a balance factor of 0, +1 or -1 which is fine.
        return node;
    }

    private Node<T> leftLeftCase(Node<T> node){
        return rightRotation(node);
    }
[O    private Node<T> rigthRightCase(Node<T> node){
        return leftRotation(node);
    }
    private Node<T> leftRightCase(Node<T> node){
        node.left=leftRotation(node.left);
        return leftLeftCase(node);
    }
    private Node<T> rightLeftCase(Node<T> node){
        node.right=rightRotation(node.right);
        return rigthRightCase(node);
    }
    private Node<T> rightRotation(Node<T> node) {
        Node<T> newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        update(node);
        update(newParent);
        return newParent;
    }
    private Node<T> leftRotation(Node<T> node) {
        Node<T> newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
    }
    private boolean contains(T value) {
        return search(value)!=null;
    }
    public Node<T> search(T value) {
        return search(value,root);
    }

    private Node<T> search(T value, Node<T> curRoot) {
        if(curRoot==null||curRoot.value==value )
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
    //  method to find the rightmost node (which has the largest value)
    public Node<T> maxValue(Node<T> cur) {
        while(cur!=null && cur.right!=null)
            cur=cur.right;
        return cur;
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
        BFs(root);
        System.out.println();
    }
    private void BFs(Node root){
        Queue<Node<T>> q=new LinkedList<>();
        HashMap<T,Integer>level=new HashMap<>();
        if(root!=null) {
            q.add(root);
            level.put((T) root.value, 1);
        }
        while(!q.isEmpty()){
            Node<T>node=q.remove();
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

public class Node<T extends Comparable<? super T>> {
    T value;
    int bf;
    int height;
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

