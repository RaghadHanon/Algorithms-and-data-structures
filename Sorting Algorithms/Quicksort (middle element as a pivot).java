public class QuickSortM {
    int []a;
    public QuickSortM(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];

        quickSortM(this.a,0,a.length-1);
    }

    private void quickSortM(int[] a,int start , int end) {
        if (start < end) {
            int pivotIndex = partition(a, start, end);
            quickSortM(a, start, pivotIndex-1);
            quickSortM(a, pivotIndex, end);
        }
    }
    private int partition(int[]a,int start , int end){
        int PIndex=(end+start)/2;
        int pivot=a[PIndex];
        int l=start,r=end;

        while (l<=r){
            while (a[l]<pivot)
                   l++;
            while (a[r]>pivot)
                  r--;
            if(l<=r) {
                swap(a, l, r);
                l++;r--;
            }
        }
        return l;

    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}

