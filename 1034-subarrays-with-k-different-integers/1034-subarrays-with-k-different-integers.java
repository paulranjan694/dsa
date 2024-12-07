class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return numberSubArr(nums,k) - numberSubArr(nums,k-1);
    }

     public int numberSubArr(int[] nums, int k){
        if(k < 0) return 0;
        int n = nums.length, l = 0, r=0,count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(r<n){
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(hm.size() > k){
                int f = hm.getOrDefault(nums[l],0);
                if(f>1){
                    hm.put(nums[l],f-1);
                }else if(f==1){
                    hm.remove(nums[l]);
                }
                l++;
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}