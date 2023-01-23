import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private T[]arr;
    private int size, head=-1,tail=-1;

    public CircularQueue() {
        arr=(T[])new Object[5];
    }
    public CircularQueue(int initialCapacity) {
       arr=(T[])new Object[initialCapacity];
    }
    public boolean isFull(){
        return size==arr.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void insureCapacity(){
        T[]copy= Arrays.copyOf(arr,2*size);
        arr=copy;
    }
    public void enqueue(T value){
        if(isFull())
            insureCapacity();
        if(head==-1)
            head=0;
        tail=(tail+1)% arr.length;
        arr[tail]=value;
        size++;

    }
    public T dequeue(){
        if(isEmpty())
            throw new NoSuchElementException();

        T removedVal=arr[head];
        head=(head+1)% arr.length;
        size--;
        return removedVal;
    }

    public T element(){
        if(isEmpty())
            throw new NoSuchElementException();
        return arr[head];
    }

    @Override
    public String toString() {
      String str="";
      for(int i=0,cur=head;i<size;i++){
          str+=arr[cur]+" ";
          cur=(cur+1)%arr.length;
      }
      return str;
    }

    public T[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }
}

