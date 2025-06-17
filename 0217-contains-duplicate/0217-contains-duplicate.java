class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<Integer>();

        for(int num : nums){
            if(uniqueNums.contains(num)){
                return true;
            }
            uniqueNums.add(num);
        }
        return false;
    }
}