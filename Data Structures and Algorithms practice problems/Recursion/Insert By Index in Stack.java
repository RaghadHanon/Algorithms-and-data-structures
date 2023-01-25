//Insert By Index in Stack
/*
Insert number n By Index in Stack (the element at the bottom of the stack has index 0)
example :
input :index= 12  ,  n=6   , stack= 4 5 1 2 3 5
output: stack= 4 5 12 1 2 3 5

*/
public static void insertByIndexOnStack(Stack<Integer> st, int val,int ind){
    insertByIndexOnStackHelper(st,st.size(),val,ind,0);
}
public static void insertByIndexOnStackHelper(Stack<Integer> st,int size, int val,int ind,int start){
    if(start==size-ind){
        st.push(val);
    }else{
        int tem=st.pop();
        insertByIndexOnStackHelper(st,size,val,ind,start+1);
        st.push(tem);
    }

}
