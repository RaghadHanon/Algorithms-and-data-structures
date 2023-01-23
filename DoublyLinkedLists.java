public class DoublyLinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    int size=0;

    public DoublyLinkedList() {

    }
    public DoublyLinkedList(T value) {
        Node<T> temp =new Node<>(value);
        head=tail=temp;
        size++;
    }
    public T get(int ind){
        if(ind <1||ind>size)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        Node<T> cur=null;
        if(ind<size/2) {
            cur=head;
            for (int i = 1; i < ind; i++) {
                cur = cur.getNext();
            }
        }else{
            cur=tail;
            for (int i = size; i > ind; i--) {
                cur = cur.getPrev();
            }
        }
        return cur.getValue();

    }
    public Node<T> getNode(int ind){
        if(ind <1||ind>size)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        Node<T> cur=null;
        if(ind<size/2) {
            cur=head;
            for (int i = 1; i < ind; i++) {
                cur = cur.getNext();
            }
        }else{
            cur=tail;
            for (int i = size; i > ind; i--) {
                cur = cur.getPrev();
            }
        }
        return cur;

    }
    public T set(int ind, T val){
        if(ind <1||ind>size)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        Node<T> cur=head;T removedVal=null;
        if(ind<size/2) {
            cur=head;
            for (int i = 1; i < ind; i++) {
                cur = cur.getNext();
            }
        }else{
            cur=tail;
            for (int i = size; i > ind; i--) {
                cur = cur.getPrev();
            }
        }
        removedVal=cur.getValue();
        cur.setValue(val);
        return removedVal;

    }
    public T set1(int ind, T val){
        if(ind <1||ind>size)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        Node<T> cur=getNode(ind);T removedVal=null;
        if(cur!=null) {
            removedVal = cur.getValue();
            cur.setValue(val);
        }
        return removedVal;

    }


    public void reverse(){

        Node <T> temp,cur=head;
        while(cur!=null){
            temp=cur.getNext();
            cur.setNext(cur.getPrev());
            cur.setPrev(temp);
            cur=cur.getPrev();//cur=temp;
        }
        temp=head;
        head=tail;
        tail=temp;
    }
    public void addFirst(T val){
        Node<T > temp=new Node<>(val);
        if(head==null) {
            head = tail = temp;
        }
        else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
        size++;
    }
    public void addLast( T val){
[O        Node<T> temp=new Node<>(val);
        if(head==null) {
            head = tail = temp;
        }else {
            tail.setNext(temp);
            temp.setPrev(tail);
            tail=temp;
        }
        size++;
    }
    public void addByIndex(int ind , T val){
        if(ind <1||ind>size+1)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        if(ind==1) addFirst(val);
        else if(ind==size+1) addLast(val);
        else {
            Node<T> temp = new Node<>(val), cur=head;
            for(int i=1;i<ind -1;i++) {
                cur=cur.getNext();
            }
            cur.getNext().setPrev(temp);
            temp.setNext(cur.getNext());
            cur.setNext(temp);
            temp.setPrev(cur);
            size++;
        }

    }
    public void addByIndex2(int ind , T val){
        if(ind <1||ind>size+1)
            throw new IndexOutOfBoundsException("Index :"+ ind);
        if(ind==1) addFirst(val);
        else if(ind==size+1) addLast(val);
        else {
            Node<T> temp = new Node<>(val), cur=getNode(ind-1);
            cur.getNext().setPrev(temp);
            temp.setNext(cur.getNext());
            cur.setNext(temp);
            temp.setPrev(cur);
            size++;
        }

    }
    public T removeFirst(){
        if(head ==null)return null;

        T removedVal=head.getValue();
        if(size==1){
            head=tail=null;
        }else {
            head=head.getNext();
            head.getPrev().setNext(null);
            head.setPrev(null);
        }
        size--;
        return removedVal;
    }
    public T removeLast() {
        if(head ==null)return null;

        T removedVal=tail.getValue();
        if(size==1) {
            head = tail = null;
        }else {
            tail = tail.getPrev();
            tail.getNext().setPrev(null);
            tail.setNext(null);
        }
        size--;
        return removedVal;
    }
    public T removeByIndex(int ind) {
        if(ind<1|| ind>size)
            throw new IndexOutOfBoundsException("Index : "+ ind);
        T removedVal=null;
        if(ind==1)removeFirst();
        else if (ind==size)removeLast();
        else{

            Node<T> cur=head,temp;
            for(int i=1;i<ind-1;i++){
                cur=cur.getNext();
            }
            removedVal=cur.getNext().getValue();
            temp=cur.getNext().getNext();
            cur.getNext().setNext(null);
            cur.setNext(temp);
            temp.getPrev().setPrev(null);
            temp.setPrev(cur);

        }
        size--;
        return removedVal;
    }
    public T removeByIndex2(int ind) {
        if(ind<1|| ind>size)
            throw new IndexOutOfBoundsException("Index : "+ ind);
        T removedVal=null;
        if(ind==1)removeFirst();
        else if (ind==size)removeLast();
        else{

            Node<T> cur=getNode(ind);
            removedVal=cur.getValue();
            cur.getNext().setPrev(cur.getPrev());
            cur.getPrev().setNext(cur.getNext());
            cur.setNext(null);
            cur.setPrev(null);
        }
        size--;
        return removedVal;
    }


    @Override
    public String toString() {
        Node<T > cur=head;
        String st="";
        while(cur!=null){
            st+=cur.getValue()+" ";
            cur=cur.getNext();
        }
        return st;
    }

    public void printListInReversedOrder() {
        Node<T > cur=tail;

        while(cur!=null){
            System.out.print(cur.getValue()+ " ");
            cur=cur.getPrev();

        }
        System.out.println("");
    }
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
public class Node <T>{
    private T value;
    private Node<T> prev;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
}

