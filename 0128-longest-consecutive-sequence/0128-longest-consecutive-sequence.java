class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        int maxlen=0;
        for(int it:set){
            if(!set.contains(it-1)){
                int len=0;
                while(set.contains(it)){
                    it++;
                    len++;
                }
                maxlen = Math.max(maxlen,len);
            }
        }

        return maxlen;

    }
}