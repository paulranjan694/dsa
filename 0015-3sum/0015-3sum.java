class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            while(i>0 && i<n && nums[i]==nums[i-1]){
                i++;
            }

            int j=i+1,k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    l.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    while(j<k && nums[j-1]==nums[j]) j++;
                }else if(nums[i]+nums[j]+nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return l;
    }
}