//Find Minimum number in a given stack

//example : 
// input : 101 4 5 44 66 33 2 14      output : 2

public static Integer findMin( MyStack<Integer> st){
    MyStack<Integer> copy=new MyStack<>();
    int mn=Integer.MAX_VALUE;
    while(!st.isEmpty()) {
        mn=Math.min(mn,st.peek());
        copy.push(st.pop());
    }
    while(!copy.isEmpty()) {
        st.push(copy.pop());
    }
    return mn;
}
