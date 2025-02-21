class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefix = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i]=bsearch(prefix,queries[i]);
        }
        return res;
    }

    private int bsearch(int[] prefix,int target){
        int left = 0,right=prefix.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(prefix[mid] <=target){
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}