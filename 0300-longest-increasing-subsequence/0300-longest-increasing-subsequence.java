class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);

        for(int i = 1; i < n; i++){
            if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
            }else{
                int idx = lowerBound(nums[i],list,0, list.size()-1);
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }

    private int lowerBound(int ele, ArrayList<Integer> list, int s, int e){
        while(s<e){
            int mid = (s+e) / 2;
            if(list.get(mid)== ele){
                return mid;
            }
            if(list.get(mid)> ele){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return s;
    }
}