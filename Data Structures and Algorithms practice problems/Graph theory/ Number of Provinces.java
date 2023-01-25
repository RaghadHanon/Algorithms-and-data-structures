//https://leetcode.com/problems/number-of-provinces/
class Solution {
    boolean []vis;
    public void dfs(int node, int[][] isConnected){
        vis[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[node][i]==1&& vis[i]==false)
             dfs(i,isConnected);
        }
    }
  
    public int findCircleNum(int[][] isConnected) {
        vis=new boolean[isConnected.length];
        int c=0;
        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==false){
             dfs(i,isConnected);
             c++;
            }
        }
        return c;
    }
}
