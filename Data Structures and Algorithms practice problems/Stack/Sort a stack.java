//sort a stack
//example:
//input: 7 4 5 1 6 9      output:1 4 5 6 7 9


public static MyStack<Integer> sort( MyStack<Integer> st){
    MyStack<Integer> copy=new MyStack<>();
    while(!st.isEmpty()) {
        Integer temp = st.pop();
        while (!copy.isEmpty() && copy.peak() > temp) {
            st.push(copy.pop());
        }
        copy.push(temp);
        System.out.println(copy);
    }
    return st=copy;
}

