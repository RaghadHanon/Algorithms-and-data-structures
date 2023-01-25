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
    public void dfs(int node) {
        dfsRecersion(node);
        clearVisited();
        System.out.println();
    }
    private void dfsRecersion(int node) {
        System.out.print(vList[node].label+"  ");
        vList[node].isVisited=true;
        for(int child=0;child<size;child++){
            if(matrix[node][child]>0&& vList[child].isVisited==false){
                dfsRecersion(child);
            }
        }
    }

    private void clearVisited (){
        for(int i=0;i<size;i++)
            vList[i].isVisited=false;

    }




}
