//https://leetcode.com/problems/find-center-of-star-graph/
class Solution {

 
    public int findCenter(int[][] edges) {
        int center=0,mx=0;
        HashMap<Integer,Integer> adj=new HashMap<>();

       for(int i=0;i<edges.length;i++){
            adj.put (edges[i][0], adj.getOrDefault(edges[i][0] , 0)+1);
            adj.put (edges[i][1], adj.getOrDefault(edges[i][1] , 0)+1);
            
       }

       for(Map.Entry<Integer ,Integer> entry : adj.entrySet()){
           if(entry.getValue()>1){
               return entry.getKey();
           }
       }
       return center;

    }
}
