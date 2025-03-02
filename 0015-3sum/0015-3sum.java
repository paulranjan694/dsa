class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1,right=n-1;
            while(left<right){
                if(right+1<n && nums[right]==nums[right+1]) {
                    right--;
                    continue;
                }

                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    ans.add(triplet);
                    left++;
                    right--;
                }else if(sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}


/**

-1,0,0,0,0,0,1,1



(0,1,5)

i-> 0 - n-2
j-> i+1 - n-1
k-> j+1 - n

cur != prev ==> duplicate


t - n^3
s - 1

[-1,0,1,2,-1,-4] - > sort --> -1,-1,0,1,2,4

-1,-1,0,1,2,4

i -> 0 - n-2
left =i+1, right = n-1

-2,-1,-1,0,1,1,1,2,4

(i,j,k)

-1,0,1
n=4
r=n-1=3
r+1 < n

arr[i]+arr[left] + arr[right] -> SummaryAPIListBuilder
if(sum==0) store the triplrt

 */