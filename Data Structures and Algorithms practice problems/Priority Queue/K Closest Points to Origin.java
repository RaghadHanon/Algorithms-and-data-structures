//https://leetcode.com/problems/k-closest-points-to-origin/
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double> pq=new PriorityQueue<>();
        HashMap<Double, ArrayList<int[]>> mp=new HashMap<>();

        for(int i=0;i< points.length;i++){

                double length=Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1] );
                pq.add(length);
                if(!mp.containsKey(length))mp.put(length,new ArrayList<>());
                mp.get(length).add(new int[]{points[i][0],points[i][1]});
            
        }

        int [][] ans=new int[k][2];
        for(int i=0 ;i<k; ){
             ArrayList<int[]> list=mp.get(pq.poll());
             for(int j=0;j<list.size()&& i<k;j++,i++){
                 ans[i]=list.get(j);
             }

        }
        return ans;
    }
  

}
