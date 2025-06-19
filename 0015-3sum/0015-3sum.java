class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i-1 >=0 && nums[i]==nums[i-1]) continue;
            int j=i+1,k=n-1;
            while(j<k){

                if(k+1 < n && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }

                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    result.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                    k--;
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}

/***
TC - n3

[-1,0,1,2,-1,-4]

Optimised one - 
-4,-1,-1,0,1,2 - nlogn

i,j,k - n2
nums
for(i->n){
    if(nums[i]==nums[i-1]) continue;
    j=i+1, k=n-1;
    while(j<k){
        if(nums[j]==nums[j-1] || nums[k]==nums[k+1]) continue;
        sum = nums[i]+nums[j]+nums[k];
        if(sum==0){
            triplet(i,j,k);
            k--;=
        }else if(sum >0){
            k--;
        }else{
            j++;
        }
    }
}

0,0,0,0,0,0,0
0 1 2 3

0,1,3
0,1,2



tc - n2+nlogn ~ n2
sc - 1

 */