class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            int l = i+1,h = n-1;
          
            while(l<=h){
                int mid = l + (h-l)/2;
                if(nums.get(i)+ nums.get(mid) < target){
                   
                    l = mid +1;
                }else{
                    h=mid-1;
                }
            }
            ans+=  l - (i + 1);;
        }
        return ans;
    }
}