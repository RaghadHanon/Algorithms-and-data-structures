//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
class Solution {

    public String reverseParentheses(String s) {
        
        Stack<Character> st=new Stack<>(),tmp=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                String b="";
                while(!st.isEmpty()&&st.peek()!='('){
                   b+= (st.pop());
                }
                if(!st.isEmpty())st.pop();
                for(int j=0;j<b.length();j++){
                  st.push(b.charAt(j));
                }
            }else st.push(s.charAt(i));
        }
        String ans="";
        while(!st.isEmpty()){
            ans = st.pop()+ans;
        }
        return ans;

    }
}
