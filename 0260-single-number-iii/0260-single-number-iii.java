class Solution {
    public int[] singleNumber(int[] nums) {
        long xor = 0;
        for(int num : nums){
            xor = xor^num;
        }

        long rightmost = (xor & xor-1) ^ xor;
        int b1=0,b2=0;
        for(int num : nums){
            if((num & rightmost) != 0){
                b1 ^= num;
            }else{
                b2 ^= num;
            }
        }

        return new int[]{b1,b2};
    }
}