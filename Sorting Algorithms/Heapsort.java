import java.util.Arrays;

public class HeapSort {

    int []a;
    public HeapSort(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];
        heapSort(this.a);
    }

    public static void heapSort(int []a){
        if(a==null)return ;
        buildHeap(a);
        for(int i=a.length-1;i>=0;i--){
            swap(a,i,0);
            heapify(a,i,0);
            System.out.println(Arrays.toString(a));
        }
    }
    public static void buildHeap(int[] a){
        int lastPerant=a.length/2-1;
        for(int i=lastPerant;i>=0;i--){
            heapify(a,a.length,i);
        }
    }

    private static void heapify(int[] a, int n,int i) {
        int  left , right , largest;
        while(true){
            left=i*2+1;
            right=i*2+2;
            largest=i;

            if(right<n&& a[right]>a[largest])
                largest=right;

            if(right<n&& a[left]>a[largest])
                largest=left;

            if(i!=largest){
                swap(a,i,largest);
                i=largest;
            }
            else break;
        }

    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
