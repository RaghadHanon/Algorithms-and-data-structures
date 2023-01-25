//https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int []inDeg=new int[n];
        for(int i=0;i<edges.size();i++){
           inDeg[ edges.get(i).get(1)]++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0)
            ans.add(i);
        }
        return ans;
    }
}
