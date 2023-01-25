//https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] a) {
        
      HashMap<String , ArrayList<String>> mp=new HashMap<>();

      for(int i=0;i< a.length;i++){
          char []arr=a[i].toCharArray();
          Arrays.sort(arr);
          String s=new String(arr);

          if(!mp.containsKey(s))mp.put(s,new ArrayList<>());
           mp.get(s).add(a[i]);
      }
      return new ArrayList<>(mp.values());
    }

}
