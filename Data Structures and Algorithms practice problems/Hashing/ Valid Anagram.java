//https://leetcode.com/problems/valid-anagram/

import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length())
        return false;
      HashMap<Character , Integer> mps=new HashMap<>();
      HashMap<Character , Integer> mpt=new HashMap<>();
      for(char x: s.toCharArray()){
          if(mps.containsKey(x)){
              mps.replace(x, mps.get(x)+1 );
          }
          else mps.put(x,1);
      }
      for(char x: t.toCharArray()){
          if(mpt.containsKey(x)){
              mpt.replace(x, mpt.get(x)+1 );
          }
          else mpt.put(x,1);
      }
     return mpt.equals(mps);

    }
}
