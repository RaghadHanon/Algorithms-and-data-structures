//sort a stack 


public static void sortStack(Stack<Integer> st,int size){
    int val=0;
    if(size!=0){
        val=st.pop();
        sortStack(st,size-1);
    }
    sortedInsertionOnStack(st,val);
    //remove elements until it becomes empty then start to add elements in a sorted way
}

public static void sortedInsertionOnStack(Stack<Integer> st, int val){
    if(st.isEmpty()|| st.peek()<=val)
        st.push(val);
    else{
        int temp=st.pop();
        sortedInsertionOnStack(st,val);
        st.push(temp);
    }
}

