// sort queue in an Ascending order
//example: 
//input: 1 7 8 4 5 3     output:1 3 4 5 7 8

public static void makerear(Queue <Integer> q,Integer ind){
    int val,mVal=0,n=q.size();
    for(int i=0;i<n;i++){
        val=q.remove();
        if(i==ind){
            mVal=val;
            continue;
        }
        q.add(val);
    }
    q.add(mVal);

}

public static Integer minIndex(Queue <Integer> q,Integer k){
    int ind=0,mn=Integer.MAX_VALUE,val;
    for(int i=0;i<q.size();i++){
        val=q.remove();
        if(i<k&& val<mn){
            mn=val;
            ind=i;
        }
        q.add(val);
    }
    return ind;
}

//sort queue
public static void sort(Queue <Integer> q){
    for(int pound=q.size();pound>0;pound--){
        makerear(q,minIndex(q,pound));
    }
}

