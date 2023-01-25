//https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
    if(nums.length==0)return 0;

    int longest=1,tempLength=1;
    HashMap<Integer,Boolean > mp=new HashMap<>();

    //Suppose all of the numbers are starting points
    for(int x:nums) mp.put(x,true);

   //find actual starting points , if X a number and there exist X-1 in the set then it's not the starting point .
    for(int x:nums) if(mp.containsKey(x-1))mp.put(x,false);

    //find max length of con. seq. , we tke the starting point and loop on Startval++ ,until we reach num that is not exist in the set .
    for(Integer StVal : mp.keySet()){
        if(mp.get(StVal)){
        int temp=StVal ;
        while(mp.containsKey(++temp)) tempLength++;
        longest=Math.max(longest,tempLength);
        tempLength=1;
        }
    }

return longest;


    
    }
}
