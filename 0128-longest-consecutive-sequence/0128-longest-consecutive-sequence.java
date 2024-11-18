class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            set.add(e);
        }
        int longest = Integer.MIN_VALUE;

        for(int it : set){
            if(!set.contains(it-1)){
                int temp=0;
                while(set.contains(it)){
                    it++;
                    temp++;
                }
                longest = Math.max(longest,temp);
            }
        }
        // for(int i = 0; i < nums.length; i++){
        //     int curr = nums[i];

        //     if(!set.contains(curr-1)){
        //         int temp=0;
        //         while(set.contains(curr)){
        //             curr++;
        //             temp++;
        //         }

        //         longest = Math.max(longest,temp);
        //     }
        // }
        return longest;
    }
}