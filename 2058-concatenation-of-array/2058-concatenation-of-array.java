class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] r = new int[2*n];

        int idx=0;
        int count=2;
        while(count-- > 0)
            for(int i=0;i<n;i++)
                r[idx++]=nums[i];
        return r;
    }
}