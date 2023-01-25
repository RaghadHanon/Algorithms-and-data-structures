//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> st=new Stack<>();
        for(Character ch:s.toCharArray()){
            if(st.isEmpty()||st.peek()!=ch)
            st.push(ch);
            else st.pop();
        }
        String ans="";
        while(!st.isEmpty()){
            ans= st.pop()+ ans;
        }
        return ans;
    }
}
