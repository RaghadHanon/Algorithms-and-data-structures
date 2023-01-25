import java.util.Arrays;
import java.util.EmptyStackException;

public class StackA<T>{
    private T[] arr;
    private int size;
    public StackA(){
        arr= (T[]) new Object[10];
    }
    public StackA(T value){
        arr[size]=value;
        size++;
    }
    public void insureCapacity(){
        if(arr.length==size){
            T[] copy= Arrays.copyOf(arr,2*size);
            arr=copy;
        }
    }
    //o(1)
    public boolean isEmpty(){
        return size==0;
    }
    //o(1)
    public T peek(){
        if(size==0)
            throw new EmptyStackException();
        return arr[size-1];
    }

    //o(1)
    public void push(T value){
        insureCapacity();
        arr[size]=value;
        size++;
    }
    //o(1)
    public T pop(){
        if(size==0)
            throw new EmptyStackException();

        size--;
        T removedval=arr[size];
        return removedval;

    }
    //o(n)
    public int search(T value){
        for(int i=size-1;i>=0;i--){
            if(arr[i].equals(value))
                return size - i;
        }
        return -1;
    }

    public String toString(){
        String st="";
        for(int i=0;i<size;i++)
            st+=arr[i]+" ";
        return st;
    }

    public T[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

}

