//Reverse a stack
/*
example :
input: 44 5 1 2 3      output : 3 2 1 5 44

*/


public static <T> MyStack<T> reverse(MyStack<T> st){
    MyStack<T> copy=new MyStack<>();
    while(!st.isEmpty()){
        copy.push(st.pop());
    }
    st=copy;
    return st;
}
