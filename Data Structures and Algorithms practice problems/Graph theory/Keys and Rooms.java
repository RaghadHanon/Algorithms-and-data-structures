//https://leetcode.com/problems/keys-and-rooms/
class Solution {
  
    boolean[]visited;
    public void dfs(int node , List<List<Integer>> rooms){
        visited[node]=true;
        for(int i=0;i<rooms.get(node).size();i++){
            if(visited[rooms.get(node).get(i)]==false)
            dfs(rooms.get(node).get(i),rooms);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
  
        visited=new boolean[rooms.size()];

        dfs(0,rooms);
        for(int i=0;i<rooms.size();i++){
            if(visited[i]==false )
            return false;
        }
        return true;

    }
}
