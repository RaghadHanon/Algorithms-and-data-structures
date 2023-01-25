//https://leetcode.com/problems/last-stone-weight/
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> q=new PriorityQueue<>( Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        q.add(stones[i]);

        while(!q.isEmpty()){
            if(q.size()>1){
                int st1=q.poll();
                int st2=q.poll();
                if(st1!=st2)
                q.add(st1-st2);
            }
            if(q.size()==1)return q.peek();
        }
        return 0;
    }

}
