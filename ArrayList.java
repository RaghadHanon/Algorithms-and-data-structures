import java.util.*;

public class ArrayList<T> {
    private T []arr;
    private int size;
    public ArrayList(){
        arr = (T[])new Object[10];
    }
    public ArrayList(int initialCapacity){
        arr = (T[])new Object[10];
        if(initialCapacity<0)
            throw new IllegalArgumentException("Argument :" + initialCapacity);
        else arr=(T[])new Object[initialCapacity];
    }
    public T get(int ind){
        if(ind<0 || ind>=size)
            throw new ArrayIndexOutOfBoundsException();
        return arr[ind];
    }
    public T set(int ind,T value){
        if(ind<0 || ind>=size)
            throw new ArrayIndexOutOfBoundsException();
        T oldValue=arr[ind];
        arr[ind]=value;
        return oldValue;
    }
    public void trimToSize(){
        if(size<arr.length){
            T []temp= Arrays.copyOf(arr,size);
            arr=temp;
        }
    }
    public void insureCapacity(){
        if(size==arr.length){
            T []temp= Arrays.copyOf(arr,size*2);
            arr=temp;
        }
    }
    public void add(T c){
        insureCapacity();
        arr[size]=c;
        size++;
    }

    //add to the end of the array
    public void addLast(T value){
        insureCapacity();
        arr[size]=value;
        size++;
    }
    //remove from the front of the array
    public T removeFirst(){
        if(size>0){
            T removedVal=arr[0];
            for(int i=1;i<size;i++){
                arr[i-1]=arr[i];
            }
            size--;
            return removedVal;
        }
        throw new ArrayIndexOutOfBoundsException("index : "+ 0);

    }
    //remove the last element of the list
    public T removeLast(){
        if(size==0)
            throw new ArrayIndexOutOfBoundsException("Index : "+ 0);

        size--;
        T removedVal=arr[size];
        return removedVal;
    }
    //add given value at the given index
    public void addByIndex(int index, T value){
        if(index<0 || index>size)
            throw new ArrayIndexOutOfBoundsException ("Index : " + index);
        else if(size==index)
            addLast(value);
        else {
            insureCapacity();
            for(int i=size-1;i>=index;i--){
                arr[i+1]=arr[i];
            }
            arr[index]=value;
            size++;
        }
    }
    //remove value at given index
    public T removeByIndex(int index){
        if(index<0 ||index>=size )
            throw new ArrayIndexOutOfBoundsException("Index : " + index);
        T removedVal=arr[index];
        for(int i=index+1;i<size;i++){
            arr[i-1]=arr[i];
        }
        size--;
        return removedVal;
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<size;i++){
            s+=arr[i]+" ";
        }
        return s;
    }




    public Object[] getArr() {
        return arr;
    }
    public int getSize() {
        return size;
    }

    public void clear(){
        size=0;
    }





}

