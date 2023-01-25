//https://leetcode.com/problems/all-paths-from-source-to-target/description/?fbclid=IwAR3hGbCiW11HTs3FqLkWtFCpSdA9gT4jzN4Gn-JXsRB--qBD7RZcnd61qaw
class Solution {

    List<List<Integer>> list=new ArrayList<>();
    public void dfs(int[][] graph,ArrayList<Integer> l,int node) {
        l.add(node);
        if(node==graph.length-1){
            list.add(new ArrayList(l));
            return;
        }
        for(int j=0;j< graph[node].length;j++){
            dfs(graph,new ArrayList(l),graph[node][j]);
        }
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,new ArrayList<>(),0 );
        return list;
    }
}
