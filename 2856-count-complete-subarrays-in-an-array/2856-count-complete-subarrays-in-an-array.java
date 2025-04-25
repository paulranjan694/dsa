class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int answer=0,l=0,r=0,n=nums.length;
        Map<Integer,Integer> hash = new HashMap<>();
        //int k = (int)Arrays.stream(nums).distinct().count();

        Set<Integer> count = new HashSet<>();
        for(int i : nums){
            count.add(i);
        }
        int k = count.size();

        while(r<n){
            hash.put(nums[r],hash.getOrDefault(nums[r],0)+1);
            while(hash.size() == k){
                answer += n-r;
                hash.put(nums[l],hash.get(nums[l])-1);
                if(hash.get(nums[l]) == 0){
                    hash.remove(nums[l]);
                }
                l++;
            }
            r++;
        }
        return answer;

    }
}