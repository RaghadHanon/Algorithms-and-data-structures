//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1)
            return false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }
            else {
                if((st.peek().equals('(')&& s.charAt(i)==')') ||(st.peek().equals('[')&& s.charAt(i)==']')||(st.peek().equals('{')&& s.charAt(i)=='}' ))
                    st.pop();
                    
                else st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }
}
