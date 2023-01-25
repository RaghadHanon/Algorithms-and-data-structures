//Arithmetic Expressions 

/* Evaluate Postfix Expression Using Stack 
example : 
input : (a+b)*(c-d)     output: ab+cd-*
*/
static MyStack <String > st= new MyStack<>();static String ans="";
public static int findPrec(String s){
    int prec=0;
    switch (s) {
        case "-":
        case "+":  prec = 1;  break;
        case "*":
        case "/":  prec = 2;  break;
    }
    return prec;

}
public static void arithmiticExpresionH(String s,int prec) {

    if(!st.isEmpty()) {
        if (prec <= findPrec(st.peak()))
            ans += st.pop();
    }
    st.push(s);
}

public static String arithmiticExpresion(String s){
    String ch;
    for(int i=0;i<s.length();i++){
        ch=s.charAt(i)+""; 
        switch(ch){
            case "+":
            case "-":arithmiticExpresionH(ch,1);break;
            case "*":
            case "/":arithmiticExpresionH(ch,2); break;
            case "(": st.push(ch);break;
            case ")":{
                while(!st.peak().equals("(")){
                    ans+=st.pop();
                }st.pop();
            }break;
            default : ans+=ch;

        }

    }
    while(!st.isEmpty())ans+=st.pop();
    return ans;
}






