//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] a, int k) {
              HashMap <Integer ,Integer> mpf=new HashMap<>();
            TreeMap <Integer ,ArrayList<Integer> > mpv=new TreeMap<>();
            for(int x:a){
                mpf.put(x, mpf.getOrDefault(x , 0)+1);
            }
            for(Map.Entry<Integer,Integer> x: mpf.entrySet()){
                if(!mpv.containsKey(-1*x.getValue()))
                mpv.put(-1*x.getValue() ,new ArrayList<Integer>());
                mpv.get(-1*x.getValue()).add(x.getKey());
            }
            int j=0; int []ans=new int[k];
            for(ArrayList<Integer>  x: mpv.values()){
                for(Integer y: x){
                    ans[j++]=y;
                    if(j==k)break;
                }
                if(j==k)break;
            }
            return ans;

    }
}
