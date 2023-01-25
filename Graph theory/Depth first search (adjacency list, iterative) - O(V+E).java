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
    public void dfs(int s) {
        Stack<Integer> st = new Stack<>();

        st.push(s);
        vList[s].isVisited = true;
        System.out.print (vList[s].label+"  ");

        while (!st.isEmpty()) {
            int node=st.peek();
            int child=getChild(node);

            if(child==-1)st.pop();
            else{
                st.push(child);
                vList[child].isVisited=true;
                System.out.print (vList[child].label+"  ");
            }
        }
        clearVisited();
        System.out.println();
    }
    private int getChild(int node) {
        for (int i = 0; i < size; i++) {
            if(matrix[node][i]>0 && vList[i].isVisited==false)
                return i;
            }
        return -1;
    }

    private void clearVisited (){
        for(int i=0;i<size;i++)
            vList[i].isVisited=false;

    }




}
