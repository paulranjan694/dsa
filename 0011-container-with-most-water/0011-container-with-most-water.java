class Solution {
    public int maxArea(int[] height) {
        int n = height.length, left = 0, right = n-1, max = 0;

        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right])*(right-left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}