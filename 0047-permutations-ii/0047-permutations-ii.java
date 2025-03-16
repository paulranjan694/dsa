class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> uniqueNums = new HashMap<>();
        for(int num : nums){
            uniqueNums.put(num, uniqueNums.getOrDefault(num, 0)+1);
        }
        permuteUtils(uniqueNums,result, new ArrayList<Integer>(), nums.length);
        return result;
    }

     private void permuteUtils(Map<Integer,Integer> mp, List<List<Integer>> result, List<Integer> list, int len){
        //base condition
        if(list.size()==len){
            List<Integer> thelist= new ArrayList<>(list);
            result.add(thelist);
            return;
        }

        for(Integer key : mp.keySet()){
            if(mp.get(key)>0){
                list.add(key);
                mp.put(key,mp.get(key)-1);
                permuteUtils(mp,result,list,len);
                list.remove(list.size()-1);
                mp.put(key,mp.get(key)+1);
            }
        }

    }

    // private void swap(int[] nums, int i, int j){
    //    int t = nums[i];
    //    nums[i]=nums[j];
    //    nums[j]=t;
    // }

    // private boolean isDuplicate(int[] nums,int start,int end){
    //     for(int i=start;i<end;i++){
    //         if(nums[i] == nums[end]){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}