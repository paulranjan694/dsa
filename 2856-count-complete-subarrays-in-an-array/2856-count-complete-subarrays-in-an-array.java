class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int answer=0,len=0;
        int[] hash = new int[2001];
        for(int num:nums){
            hash[num]++;
        }

        for(int i=0;i<2001;i++){
            if(hash[i]>0){
                len++;
            }
        }

        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=i;j<nums.length;j++){
                set.add(nums[j]);
                if(set.size() == len){
                    answer++;
                }
            }
        }
        return answer;

    }
}