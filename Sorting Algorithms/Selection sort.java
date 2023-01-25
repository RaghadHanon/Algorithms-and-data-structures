import java.util.Arrays;

public class SelectionSort {
    int []a;
    public SelectionSort(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];
        selectionSort(this.a);
    }

    public static void selectionSort(int []a){
        if(a==null)return ;

        for(int i=0;i<a.length-1;i++) {
            int minIndex=i;
            for(int j=i+1;j< a.length;j++){
                if(a[j]<a[minIndex])
                    minIndex=j;
            }
            swap(a,i,minIndex);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
