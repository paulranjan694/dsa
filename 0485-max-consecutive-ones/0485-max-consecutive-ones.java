class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int one=0,max=-1;
        for(int e: nums){
            if(e==1){
                one++;
            }else{
                max=Math.max(one,max);
                one=0;
            }
        }
        max=Math.max(one,max);
        return max;
    }
}