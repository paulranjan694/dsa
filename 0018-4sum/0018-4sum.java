class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            while(i>0 && i<n && nums[i]==nums[i-1]) i++;

            for(int j=i+1;j<n;j++){
                while(j>i+1 && j<n && nums[j]==nums[j-1]) j++;

                int k = j+1,l=n-1;
                while(k<l){
                    long sum = (long)nums[i] + nums[j] + nums[k] +nums[l];
                    if(sum > target){
                        l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        while(k<l && nums[k]==nums[k-1]) k++;
                    }
                }
            }
        }
        return res;
    }
}