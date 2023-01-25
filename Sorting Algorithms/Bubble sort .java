import java.util.Arrays;

public class PubbleSort {
    int []a;
    public PubbleSort(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];
        pubbleSort(this.a);
    }

    public static void pubbleSort(int []a){
        if(a==null)return ;

        for(int i=0;i<a.length-1;i++) {
            for(int j=0;j< a.length-i-1;j++){
                if(a[j]>a[j+1]) {
                    swap(a, j, j + 1);
                    System.out.println(Arrays.toString(a));
                }
            }
        }
    }

    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

}
