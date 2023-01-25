//https://leetcode.com/problems/find-if-path-exists-in-graph/
class Solution {

    HashMap<Integer,Boolean> visited=new HashMap<>();
    List<Integer> []adj;
    public void bfs(int s,  List<Integer> [] adj, int destination) {
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited.put(s,true);

        while(! visited.get(destination) && !q.isEmpty()){
            int node=q.remove();
            for(int i=0;i<adj[node].size();i++){
             if(visited.get(adj[node].get(i))==false){
                q.add(adj[node].get(i));
                visited.put(adj[node].get(i),true);
             }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adj=new ArrayList[n];

         for(int i=0;i<n;i++){
          visited.put(i,false);
          adj[i]=new ArrayList<>();
        }

        for(int i=0;i<edges.length;i++){
          adj[edges[i][0]].add(edges[i][1]);
          adj[edges[i][1]].add(edges[i][0]);
        }

          bfs(source , adj, destination);

          return visited.get(source)&&visited.get(destination);
    }
}
