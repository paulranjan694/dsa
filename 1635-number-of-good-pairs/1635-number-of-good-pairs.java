class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];
        for(int e : nums){
           freq[e]++;
        }

        int ans=0;
        for(int e : freq){
            if(e >1){
                ans += ((e*(e-1))/2);
            }
        }
        return ans;
    }
}