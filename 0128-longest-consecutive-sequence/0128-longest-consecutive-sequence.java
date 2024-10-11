class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int e : nums){
            set.add(e);
        }

        int longestSeq = 0;
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            if(!set.contains(curr-1)){
                int tempLongest = 1;
                while(set.contains(curr+1)){
                    tempLongest++;
                    curr++;
                }
                longestSeq = Math.max(longestSeq,tempLongest);
            }
        }

        return longestSeq;
    }
}