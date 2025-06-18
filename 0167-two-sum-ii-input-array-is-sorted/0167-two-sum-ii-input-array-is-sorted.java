class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left=0,right=n-1;

        while(left<right){
            int tempSum = numbers[left]+numbers[right];
            if(tempSum==target){
                return new int[]{left+1,right+1};
            }else if(tempSum > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[0];
    }
}