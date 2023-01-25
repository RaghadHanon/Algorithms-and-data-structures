//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(-1*nums[i]);

        PriorityQueue<Integer> q=new PriorityQueue<>(list);

         for(int i=1;i<k;i++)
            q.poll();

        return -1*q.poll();
    
    }
}
