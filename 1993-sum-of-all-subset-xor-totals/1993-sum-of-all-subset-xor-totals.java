class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int limit = (1<<n);
        int result=0;
        for(int num=0;num<limit;num++){
            int xorr=0;
            for(int bitIndex=0;bitIndex < n;bitIndex++){
                int bit = (num>>bitIndex) & 1;
                if(bit==1){
                    xorr ^= nums[bitIndex];
                }
            }
            result += xorr;
        }
        return result;
    }
}