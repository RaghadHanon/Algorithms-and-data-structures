import java.util.*;

public class GraphAd {
    int size,indx;
    List<Integer>[] adj;
    int[]level;
    int[]prv;
    HashMap<Integer,Boolean> isVisited=new HashMap<>();

    public GraphAd(int size){
        this.size=size;
        adj= new ArrayList[size];
        level=new int[size];
        prv=new int[size];
    }

    public void addVertex(int node){
        adj[node]=new ArrayList<>();
        isVisited.put(node,false);
    }
    public void addEdgeUn(int start,int end ){
        adj[start].add(end);
        adj[end].add(start);
    }
    public void addEdgeD(int start,int end ){
        adj[start].add(end);
    }

    public void PrintM (){
        for(int i=0;i<size;i++) {
            System.out.print(i+" : ");
            for (int j = 0; j < adj[i].size(); j++)
                System.out.print(adj[i].get(j)+ "  ");
            System.out.println();
        }
    }


    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        isVisited.put(s,true);
        level[s]=1;
        prv[s]=-1;

        while (!q.isEmpty()) {
            int node=q.poll();
            System.out.print (node+"  ");
            for (int i=0;i<adj[node].size();i++){
                if(isVisited.get(adj[node].get(i))==false ) {
                    q.add(adj[node].get(i));
                    level[adj[node].get(i)] = level[node]+1;
                    isVisited.put(adj[node].get(i),true);
                    prv[adj[node].get(i)]=node;
                }
            }
        }
        clearVisited();
        System.out.println();
    }
    public List<Integer > shortestPath(int start, int end){
        bfs(start);
        
        ArrayList<Integer >shPath=new ArrayList<>();
        for(int i=end; i!=-1;i=prv[i]){
            shPath.add(0,i);
        }
        if(!shPath.get(0).equals(start))return null;
        return shPath;
    }
    private void clearVisited (){
        for(int i=0;i<size;i++)
           isVisited.put(i,false);

    }




}
