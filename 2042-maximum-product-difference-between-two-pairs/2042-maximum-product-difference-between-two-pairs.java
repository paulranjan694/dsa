class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int count=2, i=0,j=nums.length-1,p1=1,p2=1;
        while(count-- > 0){
            p1 *= nums[i++];
            p2 *= nums[j--];
        }
        return p2-p1;
    }
}