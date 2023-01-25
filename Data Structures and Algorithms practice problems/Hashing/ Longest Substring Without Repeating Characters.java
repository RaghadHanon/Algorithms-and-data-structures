//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest=0;
        Map <Character,Integer> mp=new HashMap<>();
        for(int i=0,j=0;j< s.length();){
            char ch=s.charAt(j);
            mp.put(ch , mp.getOrDefault(ch,0)+1);
            if(mp.size()==j-i+1){
                longest=Math.max(longest,j-i+1);
                j++;
            }
            else if(mp.size()<j-i+1){
                while(mp.size()<j-i+1){
                    
                   ch=s.charAt(i);
                    mp.put(ch ,mp.get(ch)-1);
                     if(mp.get(ch)==0)
                          mp.remove(ch);
                    i++;
                }
                j++;
               
            }
        }

return longest;
    }
}
