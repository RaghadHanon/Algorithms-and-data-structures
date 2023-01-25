import java.util.Arrays;

public class InsertionSort {
    int []a;
    public InsertionSort(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
          this.a[i]=a[i];

        insertionSort(this.a);
    }

    public static void insertionSort(int []a){
        if(a==null)return ;

        for(int i=1;i<a.length;i++) {
            int index=i-1;
            int temp=a[i];
            while (index>=0&& a[index]>temp){
                a[index+1]=a[index];
                index--;
            }

            a[index+1]=temp;
            System.out.println(Arrays.toString(a)+ "        "+ index);

        }
    }

    public static void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
