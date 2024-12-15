class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        int maxlen=0;
        for(int i=0;i<n;i++){
            int ele = nums[i];
            if(!set.contains(ele-1)){
                int len=0;
                while(set.contains(ele)){
                    len++;
                    ele++;
                }
                maxlen = Math.max(maxlen,len);
            }
        }

        return maxlen;

    }
}