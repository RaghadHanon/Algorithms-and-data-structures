//https://leetcode.com/problems/find-the-town-judge/
class Solution {
//   1.
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
//2.
public int findJudge(int n, int[][] trust) {
        HashMap <Integer, Integer> inDeg=new HashMap<>(), outDeg=new HashMap<>();
        for(int i=1;i<=n;i++){
         outDeg.put(i,0);
         inDeg.put(i,0);
        }
        for(int i=0;i<trust.length;i++){
            outDeg.put(trust[i][0],outDeg.getOrDefault(trust[i][0],0)+1);
            inDeg.put(trust[i][1],inDeg.getOrDefault(trust[i][1],0)+1);
        }
        for(int i=1;i<=n;i++){
            if(inDeg.get(i)== n-1 && outDeg.get(i)==0)
            return i;
        }
        return -1;
    }

}
