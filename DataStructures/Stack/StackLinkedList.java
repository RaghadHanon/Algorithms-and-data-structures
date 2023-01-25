import java.util.EmptyStackException;

public class StackL<T>{
    private Node<T> Top;
    private int height;

    public StackL(){

    }
    public StackL(T value) {
        Node<T> temp=new Node<>(value);
        Top=temp;
        height++;
    }
    //o(1)
    public T peek(){
        if(height ==0)
            throw new EmptyStackException();
        return Top.getValue();
    }
    //o(1)
    public boolean isEmpty(){
        return height ==0;
    }
    //o(1)
    public void push(T value){
        Node <T> temp=new Node<>(value);
        if(Top==null) Top=temp;
        else{
            temp.setNext(Top);
            Top=temp;
        }
[O        height++;

    }
    //o(1)
    public T pop(){
        if(height ==0)
            throw new EmptyStackException();
        T removedVal= Top.getValue();
        Node <T> temp=Top;
        Top=Top.getNext();
        temp.setNext(null);
        height--;
        return removedVal;
    }
    //o(n)
    public int search(T value){
        Node cur=Top;
        for(int i=1; cur!=null;i++){
            if(cur.getValue().equals(value))
                return i;
            cur=cur.getNext();
        }
        return -1;
    }


    public void printFromTop(){
        Node cur=Top;
        while(cur!=null){
            System.out.print(cur.getValue() + " ");
            cur=cur.getNext();
        }
        System.out.println();
    }
    public void printToTop(){
        helperPrintToTop(Top);
        System.out.println();
    }
    public void helperPrintToTop(Node<T> cur){
        if(cur==null)return ;
        helperPrintToTop(cur.getNext());
        System.out.print(cur.getValue()+" ");
    }
    public String helperToString(Node<T> cur){
        if(cur==null)return "";
        return (helperToString(cur.getNext()) + cur.getValue()+" ");
    }
    public String toString(){
        return helperToString(Top);
    }

    public Node<T> getTop() {
        return Top;
    }

    public void setTop(Node<T> top) {
        Top = top;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
public class Node <T>{
    private T value;
    private Node<T> next;
    public Node(T value){
        this.value=value;
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

