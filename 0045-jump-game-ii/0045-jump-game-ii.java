class Solution {
    public int jump(int[] nums) {
        int left=0,right=0,minJumps = 0,n=nums.length;

        while(right < n-1){
            int furthest = 0;

            for(int i=left;i<=right;i++)
                furthest = Math.max(furthest,nums[i]+i);
            
            left = right + 1;
            right = furthest;
            minJumps++; 
        }
        return minJumps;
    }
}