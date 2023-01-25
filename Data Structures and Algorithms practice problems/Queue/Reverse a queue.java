// Q.Reverse a queue
//example :
//input :1 2 4 5 6     output:6 5 4 2 1 


//Iterative
public static <T>MyQueue <T>  reverse(MyQueue <T> q){
    Stack<T> st=new Stack<>();
    while(!q.isEmpty()){
        st.push(q.remove());
    }
    while(!st.isEmpty()){
        q.add(st.pop());
    }
    return q;
}

//recursive
public static <T>MyQueue <T>  reverse2(MyQueue <T> q){
   if(q.isEmpty())
       return q;
   T data =q.remove();
   q= reverse2(q);
   q.add(data);
   return q;
}


