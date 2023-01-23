public class LinkedList<T> {
    private Node<T> head,tail;
    private int size;

    public LinkedList() {
    }
    public LinkedList(T value) {
        Node<T> temp=new Node<>(value);
        head=tail=temp;
        size++;
    }

    private int findOrder(Integer temp){
        if (head==null)
            return 1;
        Node cur=head;
        for(int i=1;cur!=null;i++){
            if(temp<=(Integer) cur.getValue())
                return i;
            cur=cur.getNext();
        }
        return size+1;
    }

    // o(1)
    public void clear(){
        size=0;
        head=tail=null;
    }
    //o(1)
    public boolean isEmpty(){
        return size==0;
    }
    //o(n)
    public Node<T> get(int ind) {
        if (ind < 1 || ind > size ) {
            throw new IndexOutOfBoundsException("Index :" + ind);
        } else {
            Node<T> cur = head;
            for (int i = 1; i < ind ;i++){
                cur=cur.getNext();
            }
            return cur;
        }
    }
    public void set( int ind,T value ){
        if(ind<1|| ind>size)
            throw new IndexOutOfBoundsException("Index : "+ind);
        Node<T> cur=head;
        for(int i=1;i<ind ;i++){
            cur=cur.getNext();
        }
        cur.setValue(value);
    }
    public boolean set1( int ind,T value ) {

        Node<T> cur = get(ind);
        if (cur != null) {
            cur.setValue(value);
            return true;
        }
        return false;
    }
    //o(1)
    public void addFirst(T value){
        Node<T> temp =new Node<>(value);
        if(head==null){
            head=tail =temp;
        }else{
            temp.setNext(head);
            head =temp;
        }
        size++;
    }
    //o(1)
    public void addLast(T value){
        Node<T> temp =new Node<>(value);
        if(head==null){
            head=tail =temp;
        }else{
            tail.setNext(temp);
            tail =temp;
        }
        size++;
    }
    //O(N)
    public void addByIndex( int ind,T value){

        if(ind<1 || ind>size+1){
            throw new IndexOutOfBoundsException("Index :" +ind);
        }
        Node<T> temp=new Node<>(value);
        if(ind==1){
            addFirst(value);
        }else if(ind==size+1){
            addLast(value);
        }else{
            Node<T> cur=head;
            for(int i=1;i< ind-1;i++){
                cur=cur.getNext();
            }
            temp.setNext(cur.getNext());
            cur.setNext(temp);
            size++;
        }
    }
    //o(n)
    public T removeLast(){
        T removedVal;
        if(size==0) return null;
        else if(size==1){
            removedVal=head.getValue();
            head=tail=null;
        }else{
            Node<T> cur=head;
            while(cur.getNext().getNext()!=null){
                cur=cur.getNext();
            }
            removedVal=cur.getNext().getValue();
            tail=cur;
            tail.setNext(null);
        }
        size--;
        return removedVal;

    }
    //o(1)
    public T removeFirst(){
        if(head==null)return null;
        T removedValue=  head.getValue();
        if(head==tail)   head=tail=null;
        else {
            Node <T>temp=head;
            head=head.getNext();
            temp.setNext(null);
        }
        size--;
        return removedValue;//return temp;
    }
    //o(n)
    public T removeLast2(){

        if(size==0)  return null;

        Node<T> prv=head,temp=head;
        while(temp.getNext()!=null){
            prv=temp;
            temp=temp.getNext();
        }
        T  removedVal=(T)temp.getValue();
        tail=prv;
        tail.setNext(null);
        size--;
        if(size==0)
            head=tail=null;
        return removedVal;//return temp

    }
    public T removeByIndex(int ind){
        if(ind<1||ind>size)
            throw new IndexOutOfBoundsException("Index : "+ ind);
        T removedVal=null;
        if(ind==1)removeFirst();
        else if(ind==size)removeLast();
        else {
            Node<T> cur = head, temp ;
            for (int i = 1; i < ind -1; i++) {
                cur = cur.getNext();
            }
            removedVal = cur.getNext().getValue();
            temp = cur.getNext().getNext();
            cur.getNext().setNext(null);
            cur.setNext(temp);
            size--;
        }
        return removedVal;//return temp

    }



    public boolean contains(T value){
        Node<T> cur=head;
        while(cur!=null){
            if(cur.getValue().equals(value))
                return true;
            cur=cur.getNext();
        }
        return false;
    }
    public void reverse(){
        Node<T> cur=head,prv=null,nxt=head;
        while(nxt!=null){
            nxt=cur.getNext();
            cur.setNext(prv);
            prv=cur;
            cur=nxt;
        }
        tail=head;
        head=prv;


    }

    public Node<T> reverseList(Node<T> head) {
        // Special case...
        if (head == null || head.getNext() == null) return head;
        // Create a new node to call the function recursively and we get the reverse linked list...
        Node<T> res = reverseList(head.getNext());
        // Set head node as head.next.next...
        head.getNext().setNext(head);
        //set head's next to be null...
        head.setNext(null);
        return res;     // Return the reverse linked list...
    }
    // creat a new copy
    public Node<T> copy(Node<T> head) {
        Node<T> cur=head ,temp=new Node<>(head.getValue()),hd=temp;
        cur=cur.getNext();
        while(cur!=null){
            temp.setNext(new Node<T>(cur.getValue()));
            temp=temp.getNext();
            cur=cur.getNext();
        }
        return hd;
    }
    //middle element in a list
    public Node<T> findMiddle(){
        Node<T> slow=head,fast=head;
        while(fast!=null &&fast.getNext()!=null){
            slow=slow.getNext();
            fast=fast.getNext().getNext();
        }
        return slow;
    }
    //rotate the list r times to the Left
    public void rotateLeft(int r){
        if (head!=null&&r!=0){
            r%=size;
            Node<T> fast=head,slow=head, newHead;int c=1;
            while(fast.getNext()!=null){
                if(c<size-r)
                    slow=slow.getNext();
                fast=fast.getNext();
                c++;
            }
            newHead=slow.getNext();
            tail=slow;
            slow.setNext(null);
            fast.setNext(head);
            head=newHead;
        }
    }
    //rotate the list r times to the right
    public void rotateRight(int r){
        if(head!=null&&r!=0){
            r%=size;
            Node<T> slow=head,fast=head,newHead;
            for(int i=1;i<r;i++){
                fast=fast.getNext();
            }
            head=fast.getNext();
            fast.setNext(null);
            tail.setNext(slow);
            tail=fast;
        }
    }
    //swap
    public void swapNodes(int ind1,int ind2){
        if(ind1 <0 || ind2<0 ||ind1>size || ind2>size)
            throw new IndexOutOfBoundsException("");
        if(ind1!=ind2){
            if(ind1>ind2){
                int t=ind1;ind1=ind2;ind2=t;
            }
            Node <T> fast1=head,slow1=null,fast2=head,slow2=null,temp;
            for(int i=1;i< ind1;i++){
                slow1=fast1;
                fast1=fast1.getNext();
            }
            for(int i=1;i< ind2;i++){
                slow2=fast2;
                fast2=fast2.getNext();
            }
            if(slow1!=null) slow1.setNext(fast2);
            slow2.setNext(fast1);
            temp=fast1.getNext();
            fast1.setNext(fast2.getNext());
            fast2.setNext(temp);
            if(ind1==1)  head=fast2;
            if(ind2==size)   tail=fast1;

        }
    }



    public void printList(){
        Node<T> cur=head;
        while(cur!=null){
            System.out.print(cur.getValue()+ " ");
            cur=(cur.getNext());
        }
    }

    public String toString(){
        String str="";
        Node<T> cur=head;
        while(cur!=null){
            str+=cur.getValue()+" ";
            cur=(cur.getNext());
        }
        return str;
    }
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public class Node<T> {
        private T value;
        private Node<T> next;
        public Node (T value){
            this.value=value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}

