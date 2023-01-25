public class QuickSortE {
    int []a;
    public QuickSortE(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];

        quickSortE(this.a,0,a.length-1);
    }

    private void quickSortE(int[] a,int start , int end) {
        if(start<end) {
            int pivotIndex = partition(a, start, end);
            quickSortE(a, start, pivotIndex - 1);
            quickSortE(a, pivotIndex + 1, end);
        }
    }
    private int partition(int[]a,int start , int end){
        int PIndex=start;
        int pivot=a[end];

        for(int i=start;i<end;i++){
            if(a[i]<=pivot){
                swap(a,i,PIndex);
                PIndex++;
            }
        }
        swap(a,PIndex,end);
        return PIndex;
    }
    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
