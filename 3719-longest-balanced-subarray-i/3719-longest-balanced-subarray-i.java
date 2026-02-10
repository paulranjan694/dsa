class Solution {
    public int longestBalanced(int[] nums) {
        int n=nums.length,max=0;
        Set<Integer> evens = new HashSet<>();
        Set<Integer> odds = new HashSet<>();

        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                evens.add(nums[i]);
            }else{
                odds.add(nums[i]);
            }

            for(int j=i+1;j<n;j++){
                if(nums[j] % 2 == 0){
                    evens.add(nums[j]);
                }else{
                    odds.add(nums[j]);
                }

                if(evens.size() == odds.size()){
                    max = Math.max(max,j-i+1);
                }
            }
            evens.clear();
            odds.clear();
        }

        return max;
    }
}