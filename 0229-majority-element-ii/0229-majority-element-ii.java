class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = Integer.MIN_VALUE,ele2 = Integer.MIN_VALUE, cnt1 = 0, cnt2=0, n= nums.length;

        for(int i=0;i<n;i++){
            if(cnt1==0 && ele2 != nums[i]){
                ele1=nums[i];
                cnt1=1;
            }else if(cnt2==0 && ele1 != nums[i]){
                ele2=nums[i];
                cnt2=1;
            }else if(ele1==nums[i]){
                cnt1++;
            }else if(ele2==nums[i]){
                cnt2++;
            }
            else{
                cnt1--;cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;

        for(int i=0;i<n;i++){
            if(ele1 == nums[i]){
                cnt1++;
            }else if(ele2 == nums[i]){
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(cnt1 > Math.floor(n/3)) {
            ans.add(ele1);
        }

        if(cnt2 > Math.floor(n/3)) {
            ans.add(ele2);
        }
        return ans;
    }
}