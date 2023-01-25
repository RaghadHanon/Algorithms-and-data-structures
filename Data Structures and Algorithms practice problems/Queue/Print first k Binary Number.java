// Print first k Binary Number
// example :
// input: k=5      output: 1 10 11 100 101
public static void PrintPinaryNumber(int k){
    MyQueue<String>q=new MyQueue<>();
    String []arr=new String[k];
    q.add("1"); arr[0]="1";
    for(int i=1;i<k;i+=2){
        String temp=q.remove();
        arr[i]=temp+"0";
        if(i+1<k) arr[i+1]=temp+"1";
        q.add(temp+"0");
        q.add(temp+"1");
    }
    System.out.println(Arrays.toString(arr));
}
