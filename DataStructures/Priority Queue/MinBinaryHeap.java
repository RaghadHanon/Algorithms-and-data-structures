import java.util.*;

public class minBinaryHeap<T extends Comparable <? super T>>{

    // A dynamic list to track the elements inside the heap
    private List<T> heap;
    // Construct and initially empty priority queue
    public minBinaryHeap(){
        this(1);
    }
    // Construct and initially empty priority queue
    public minBinaryHeap(int size) {
        heap=new ArrayList<>(size);
    }
    // Construct a priority queue using heapify in O(n) time:
    public minBinaryHeap(T[] arr) {
        int heapSize=arr.length;
        heap=new ArrayList<>(heapSize);

        // Place all element in heap
        for(int i=0;i<heapSize;i++)
            heap.add(arr[i]);

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--)
            sink(i);
    }

    public minBinaryHeap(Collection<T> elems){
        int heapSize=elems.size();
        heap = new ArrayList<T>(heapSize);

        // Add all elements of the given collection to the heap
        heap.addAll(elems);

        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--)
            sink(i);
    }




    // Returns true/false depending on if the priority queue is empty
    public boolean isEmpty(){
        return size()==0;
    }

    // Return the size of the heap
    public int size(){
        return heap.size();
    }

    // Clears everything inside the heap, O(n)
    public void clear (){
        heap.clear();
    }


    // Returns the value of the element with the lowest
    // priority in this priority queue. If the priority
    // queue is empty null is returned.
    public T peek(){
        if(isEmpty())
            return null;
        return heap.get(0);
    }



    // Removes the root of the heap, O(log(n))
    public T poll(){
        return removeAt(0);
    }


    // Test if an element is in heap, O(n)
    public boolean contains(T val){
        // Linear scan to check containment
        for(int i=0;i< heap.size();i++){
            if(heap.get(i).equals(val))
                return true;
        }
        return false;
    }

    // Adds an element to the priority queue, the
    // element must not be null, O(log(n))
    public void add(T val){
        if(val==null)
            throw new IllegalArgumentException();
        heap.add(val);

        int indexOfLastElem=(size()-1);

        swim(indexOfLastElem);

    }
    // Removes a particular element in the heap, O(n)
    public boolean remove(T val){
        if(val==null)return false;

        // Linear removal via search, O(n)
        for (int i=0;i< heap.size();i++){

            if(heap.get(i).equals(val)){
                removeAt(i);
                return true;
            }
        }
        return false;
    }


    // Removes a node at particular index, O(log(n))
    private T removeAt(int i) {
        if (isEmpty())return null;

        int indexOfLastElem=(size()-1);
        T removedVal=heap.get(i);
        swap(i,indexOfLastElem);

        // Obliterate the value
        heap.remove(indexOfLastElem);

        // Check if the last element was removed
        if(i==indexOfLastElem)
            return removedVal;

        T temp= heap.get(i);

        // Try sinking element
        sink(i);

        // If sinking did not work try swimming
        if(temp.equals(heap.get(i)))
            swim(i);
        return removedVal;

    }


    // Tests if the value of node i <= node j
    // This method assumes i & j are valid indices, O(1)

    private boolean lessOrEqual(int i,int j){
        T valAtIndexI = heap.get(i);
        T valAtIndexJ = heap.get(j);
        return valAtIndexI.compareTo(valAtIndexJ)<=0;
    }

    // Perform bottom up node swim, O(log(n))
    private void swim(int k) {
      // Grab the index of the next parent node WRT to k
      int parentInd=(k-1)/2;

     // Keep swimming while we have not reached the
     // root and while we're less than our parent.
      while (k>0 && lessOrEqual(k,parentInd)){

          // Exchange k with the parent
          swap(k,parentInd);
          k=parentInd;
          parentInd=(k-1)/2;
      }
    }


    private void sink(int k) {
        int left,right, smallest;

        while(true){
             left= 2*k+1;   // Left  node
             right= 2*k+2;   // Right node
             smallest =left;// Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
             if(right<size()&& lessOrEqual(right,left))
                 smallest=right;

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
             if(left>=size()|| lessOrEqual(k,smallest))break;


            // Move down the tree following the smallest node
             swap(smallest,k);
             k=smallest;
        }
    }
    private void swap(int i,int j){
        T temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }



    // Recursively checks if this heap is a min heap
    // This method is just for testing purposes to make
    // sure the heap invariant is still being maintained
    // Called this method with k=0 to start at the root
    public boolean isMinHeap(int k) {
        // If we are outside the bounds of the heap return true
        int heapSize = size();
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // Make sure that the current node k is less than
        // both of its children left, and right if they exist
        // return false otherwise to indicate an invalid heap
        if (left < heapSize && !lessOrEqual(k, left)) return false;
        if (right < heapSize && !lessOrEqual(k, right)) return false;

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

