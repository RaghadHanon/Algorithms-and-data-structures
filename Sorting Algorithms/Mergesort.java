import java.util.Arrays;

public class MergeSort {

    int []a;
    public MergeSort(int[]a){
        this.a=new int[a.length];
        for(int i=0;i<a.length;i++)
            this.a[i]=a[i];

        this.a=mergeSort(this.a);
    }

    public static int[] mergeSort(int []a){

        System.out.println(Arrays.toString(a));
        if(a.length>1) {
            int mid = a.length / 2;
            int[] left = Arrays.copyOfRange(a, 0, mid);
            int[] right = Arrays.copyOfRange(a, mid, a.length);

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }
        return a;
    }

    private static int[] merge(int[] left, int[] right) {
        int []mer=new int[left.length+right.length];
        int l=0,r=0,ind=0;
        while(l<left.length|| r<right.length){
            if( r==right.length  ||  (l<left.length && left[l]<=right[r])){
                mer[ind++]=left[l++];
            }else if( l==left.length  ||( r<right.length && right[r]<=left[l])){
                mer[ind++]=right[r++];
            }
        }

        System.out.println(Arrays.toString(mer));
        return mer;
    }

}
