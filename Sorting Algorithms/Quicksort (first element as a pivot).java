public class QuickSortP {
    int []a;
    public QuickSortP(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];

        quickSortP(this.a,0,a.length-1);
    }

    private void quickSortP(int[] a,int start , int end) {
        if(start<end) {
            int pivotIndex = partition(a, start, end);
            quickSortP(a, start, pivotIndex - 1);
            quickSortP(a, pivotIndex + 1, end);
        }
    }
    private int partition(int[]a,int start , int end){
        int PIndex=end;
        int pivot=a[start];

        for(int i=start+1;i<=end;i++){
            if(a[i]>=pivot){
                swap(a,i,PIndex);
                PIndex--;
            }
        }
        swap(a,PIndex,start);
        return PIndex;
    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}

