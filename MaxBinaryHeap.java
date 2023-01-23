import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class maxBinaryHeap <T extends Comparable <? super T> > {

   private List<T> heap;

   public maxBinaryHeap() {
      this(1);
   }

   public maxBinaryHeap(int size) {
      heap = new ArrayList<>(size);
   }

   public maxBinaryHeap(T[] arr) {
      int heapSize = arr.length;

      heap = new ArrayList<>(heapSize);
      for (int i = 0; i < heapSize; i++)
         heap.add(arr[i]);

      for (int i = (heapSize / 2) - 1; i >= 0; i--) {
         sink(i);
      }

   }

   public maxBinaryHeap(Collection<T> elems) {
      int heapSize = elems.size();

      heap = new ArrayList<>(heapSize);

      heap.addAll(elems);

      for (int i = (heapSize / 2) - 1; i >= 0; i--) {
         sink(i);
      }

   }

   public boolean isEmpty() {
      return size() == 0;
   }

   public int size() {
      return heap.size();
   }

   public void clear() {
      heap.clear();
   }

   public T peek() {
      if (isEmpty()) return null;
      return heap.get(0);
   }

   public T poll() {
      return removeAt(0);
   }

   public boolean contains(T val) {
      for (int i = 0; i < size(); i++) {
         if (val.equals(heap.get(i)))
            return true;
      }
      return false;
   }

   public void add(T val) {
      if (val == null)
         throw new IllegalArgumentException();
      heap.add(val);
      int indxOfLastElem = size() - 1;
      swim(indxOfLastElem);
   }

   public boolean largerOrEqual(int i, int j) {
      T valAtIndexI = heap.get(i);
      T valAtIndexJ = heap.get(j);
      return valAtIndexI.compareTo(valAtIndexJ) >= 0;
   }

   public void swap(int i, int j) {
      T temp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, temp);
   }

   public void swim(int k) {
      int parent = (k - 1) / 2;

      while (k > 0 && largerOrEqual(k, parent)) {
         swap(k, parent);
         k = parent;
         parent = (k - 1) / 2;
      }
   }

   public void sink(int k) {
      int heapSize = size(), left, right, lergest;
      while (true) {
         left = k * 2 + 1;
         right = k * 2 + 2;
         lergest = left;

         if (right < heapSize && largerOrEqual(right, left))
            lergest = right;

         if (left >= heapSize || largerOrEqual(k, lergest)) break;

         swap(lergest, k);
         k = lergest;

      }

   }
   public boolean remove(T val){
      if(val==null)return false;
      for(int i=0;i<size();i++) {
         if (val.equals(heap.get(i))) {
            removeAt(i);
            return true;
         }
      }
      return false;
   }

   public T removeAt(int i) {
      if(isEmpty())return null;

      int indexAAtLastElem=size()-1;

      T removedVal=heap.get(i);

      swap(i,indexAAtLastElem);
      heap.remove(indexAAtLastElem);
      if(i==indexAAtLastElem)return removedVal;

      T temp=heap.get(i);
      sink(i);
      if(temp.equals(heap.get(i)))
         swim(i);
   return removedVal;
   }

   public boolean isMaxHeap(int k) {
      if (k >= size())
         return true;
      int left = 2 * k + 1;
      int right = 2 * k + 2;

      if(left<size()&& largerOrEqual(left,k))return false;
      if(right<size()&& largerOrEqual(right,k))return false;

      return isMaxHeap(left)&& isMaxHeap(right);
   }

   @Override
   public String toString() {
      return ""+ heap ;
   }
}

