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
    public void dfsRec(int node) {
        dfsRecersion(node);
        clearVisited();
        System.out.println();
    }
    private void dfsRecersion(int node) {
        System.out.print(node+"  ");
        isVisited.put(node,true);
        for(int i=0;i<adj[node].size();i++){
            if(isVisited.get(adj[node].get(i))==false){
                dfsRecersion(adj[node].get(i));
            }
        }
    }
 
    private int getChild(int node) {
        for (int i = 0; i < adj[node].size(); i++) {
            if(isVisited.get(adj[node].get(i))==false)
                return adj[node].get(i);
        }
        return -1;
    }

    private void clearVisited (){
        for(int i=0;i<size;i++)
           isVisited.put(i,false);

    }




}
