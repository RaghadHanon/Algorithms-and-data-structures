//Add number k to a sorted stack .
//example :
//input:  k=8   , stack: 1 2 5 12 45     output:  stack: 1 2 5 8 12 45 

public static void addSorted(Integer value, MyStack<Integer> st){
        MyStack<Integer> copy=new MyStack<>();
    
        while(!st.isEmpty() && value <st.peak()){
            copy.push(st.pop());
        }
        st.push(value);
        while(!copy.isEmpty() ){
            st.push(copy.pop());
        }
    
}
