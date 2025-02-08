class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int n = nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            int l = i+1,h = n-1;
            int tempCount=0;
            while(l<=h){
                int mid = l + (h-l)/2;
                if(nums.get(i)+ nums.get(mid) < target){
                    tempCount += mid-l+1;
                    l = mid +1;
                }else{
                    h=mid-1;
                }
            }
            ans+= tempCount;
        }
        return ans;
    }
}