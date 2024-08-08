class Solution {
    public int jump(int[] nums) {
        int end=0,far=0,jumps=0;
        while(far<nums.length-1){
            int temp=far;
            for(int i = end;i<=temp;i++){
                far = Math.max(i+nums[i],far);
            }
            end=temp+1;
           jumps++;
        }
        return jumps;
    }
}