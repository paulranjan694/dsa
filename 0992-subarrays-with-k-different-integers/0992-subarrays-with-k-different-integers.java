class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMostK(nums, k) - countAtMostK(nums, k-1);
    }

    public int countAtMostK(int arr[], int k) {
        int left=0,right=0, ans=0, n=arr.length;
        Map<Integer,Integer> mp = new HashMap<>();
        
        while(right<n){
            mp.put(arr[right], mp.getOrDefault(arr[right],0)+1);
            
            while(mp.size() >k){
                mp.put(arr[left], mp.get(arr[left])-1);
                if(mp.get(arr[left]) <= 0){
                    mp.remove(arr[left]);
                }
                left++;
            }
            
            ans += right-left+1;
            right++;
            
        }
        return ans;
    }
}