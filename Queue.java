import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front, rear;
    private int size;

    public Queue() {
    }
    public Queue(T value) {
        Node<T> temp=new Node<>(value);
        front= rear =temp;
        size++;
    }
    // o(1)
    public void clear(){
        size=0;
        front= rear =null;
    }
    //o(1)
    public boolean isEmpty(){
        return size==0;
    }
    //o(1)
    public T element(){
        if(front==null)
            throw new NoSuchElementException();
        return front.getValue();
    }
    //o(1)
    public T peek(){
        if(front==null)
           return null;
        return front.getValue();
    }
    //o(1)
    public void add(T value){
        Node<T> temp =new Node<>(value);
        if(front==null){
            front= rear =temp;
        }else{
            rear.setNext(temp);
            rear =temp;
        }
        size++;
    }

    //o(1)
    public T remove(){
        if(front==null)
            throw new NoSuchElementException();

        T removedValue=  front.getValue();
        if(front== rear)   front= rear =null;
        else {
            Node <T>temp=front;
            front=front.getNext();
            temp.setNext(null);
        }
        size--;
        return removedValue;//return temp;
    }
    public T poll(){
        if(front==null)return null;

        T removedValue=  front.getValue();
        if(front== rear)   front= rear =null;
        else {
            Node <T>temp=front;
            front=front.getNext();
            temp.setNext(null);
        }
        size--;
        return removedValue;//return temp;
    }
    @Override
    public String toString() {
        String str="";
        Node<T> cur=front;
        while(cur!=null){
            str+=cur.getValue()+" ";
            cur=(cur.getNext());
        }
        return str;
    }

    public T getFront() {
        if(front==null)throw new NoSuchElementException();
        return front.getValue();
    }

    public T getRear() {
        if(front==null)throw new NoSuchElementException();
        return rear.getValue();

    }

    public int getSize() {
        return size;
    }


}

