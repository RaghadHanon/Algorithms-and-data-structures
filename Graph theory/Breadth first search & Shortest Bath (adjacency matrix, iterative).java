import java.util.*;

public class Graph {
    int size,indx;
    int [][]matrix;
    Vertex[]vList;
    int[]level;
    int[]prv;

    public Graph(int size){
        this.size=size;
        matrix=new int[size][size];
        vList=new Vertex[size];
        level=new int[size];
        prv=new int[size];
    }

    public void addVertex(String label){
        vList[indx++]=(new Vertex(label));
    }
    public void addEdgeUn(int start,int end ){
        matrix[start][end]=1;
        matrix[end][start]=1;
    }
    public void addEdgeD(int start,int end ){
        matrix[start][end]=1;
    }
    public void addEdgeUnW(int start,int end ,int weight){
        matrix[start][end]=weight;
        matrix[end][start]=weight;
    }
    public void addEdgeDW(int start,int end ,int weight){
        matrix[start][end]=weight;
    }
    public void PrintM (){
        for(int i=0;i<size;i++) {
            for (int j = 0; j < size; j++)
                System.out.print(matrix[i][j]+ "  ");
            System.out.println();
        }
    }
    
    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        vList[s].isVisited = true;
        level[s]=1;
        prv[s]=-1;

        while (!q.isEmpty()) {
            int node=q.poll();
            System.out.print (vList[node].label+"  ");
            for (int child=0;child<size;child++){
                if(matrix[node][child]>0&&vList[child].isVisited==false ) {
                    q.add(child);
                    level[child] = level[node]+1;
                    vList[child].isVisited=true;
                    prv[child]=node;
                }
            }
        }
        clearVisited();
        System.out.println();
    }
    public List<String > shortestPath(int start, int end){
        bfs(start);

        ArrayList<String >shPath=new ArrayList<>();
        for(int i=end; i!=-1;i=prv[i]){
            shPath.add(0,vList[i].label);
        }
        if(!shPath.get(0).equals(start))return null;
        return shPath;
    }
    private void clearVisited (){
        for(int i=0;i<size;i++)
            vList[i].isVisited=false;

    }


public class Vertex {
    String label;
    boolean isVisited;

    public Vertex(String label){
        this.label=label;
    }
    public Vertex(String label,boolean isVisited){
        this.label=label;
        this.isVisited=isVisited;
    }
}


}
