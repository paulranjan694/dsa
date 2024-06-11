class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> hm = new HashMap<>();
        int max=0,sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum+=-1;
            }else{
                sum+=nums[i];
            }
            if(sum==0){
                max=Math.max(max,i+1);
            }
            int f = hm.getOrDefault(sum,-1);
            if(f!=-1){
                max=Math.max(max,i-f);
            }else{
                hm.put(sum,i);
            }
        }
        return max;
    }
}