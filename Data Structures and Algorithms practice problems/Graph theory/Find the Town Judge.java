//https://leetcode.com/problems/find-the-town-judge/
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[]inDeg=new int[n+1], outDeg=new int [n+1];
       
        for(int i=0;i<trust.length;i++){
            outDeg[trust[i][0]]++;
            inDeg[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(inDeg[i]== n-1 && outDeg[i]==0)
            return i;
        }
        return -1;
    }
}
