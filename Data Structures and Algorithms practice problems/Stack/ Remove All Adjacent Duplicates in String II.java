//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack <Pair> st=new Stack<>();
        for(Character ch: s.toCharArray()){
            if(st.isEmpty()||st.peek().key!= ch)
            st.push(new Pair(ch,1));
            else{
                if( st.peek().Value==k-1)
                   st.pop();
                else st.peek().Value++;
            }

        }
        String ans ="";
        for(Pair x:st){
            
            for(int i=0;i<x.Value;i++)
            ans+= x.key ;

        }

return ans;
    }
}
class Pair{
    Character key;
    Integer Value;
    public Pair(Character key, Integer Value){
         this.key=key;
         this.Value=Value;
    }

}
