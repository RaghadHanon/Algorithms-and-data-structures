//Sorted Insertion on stack.
/*
Add number k to a sorted stack
example :
input:  k=8   , stack: 1 2 5 12 45     output:  stack: 1 2 5 8 12 45 
*/
public static void sortedInsertionOnStack(Stack<Integer> st, int val){
    if(st.isEmpty()|| st.peek()<=val)
        st.push(val);
    else{
        int temp=st.pop();
        sortedInsertionOnStack(st,val);
        st.push(temp);
    }
}
