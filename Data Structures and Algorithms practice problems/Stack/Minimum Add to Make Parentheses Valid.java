//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    public int minAddToMakeValid(String s) {
    
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }
            else if((st.peek().equals('(')&& s.charAt(i)==')') ||(st.peek().equals('[')&& s.charAt(i)==']')||(st.peek().equals('{')&& s.charAt(i)=='}' ))
                    st.pop();
                    
            else st.push(s.charAt(i));
            }
            
        return st.size();
        
    }
}
