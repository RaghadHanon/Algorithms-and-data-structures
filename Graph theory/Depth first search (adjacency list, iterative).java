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
    public void dfs(int s){
        Stack<Integer>st=new Stack<>();
        st.push(s);
        isVisited.put(s,true);
        System.out.print(s+ "  ");

        while (!st.isEmpty()){
            int node=st.peek();
            int child =getChild(node);

            if(child==-1)st.pop();
            else{
                st.push(child);
                isVisited.put(child,true);
                System.out.print(child+ "  ");
            }
        }

        clearVisited();
        System.out.println();
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
