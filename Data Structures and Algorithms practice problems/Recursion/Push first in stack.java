// Push first in stack
/*
Push n number to the bottom of a stack 
example : 
input : n=78      stack : 4 5 1 2 
output : 78 4 5 1 2

*/
public static void pushFirstStack(Stack<Integer> st, int val){
    if(st.isEmpty()) {
        st.push(val);
        return;
    }
    int value=st.pop();
    pushFirstStack(st,val);
    st.push(value);
}

