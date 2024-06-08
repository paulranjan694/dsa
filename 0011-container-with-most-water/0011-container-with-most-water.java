class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int max = height[0];
        int n=height.length;
        int i=0,j=n-1;
        while(i<j){
           int min=Math.min(height[i],height[j]);
           int b=j-i;
           answer = Math.max(answer,min*b);
           if(height[i]>height[j]){
               j--;
           }else{
              i++;
           }
        }
        return answer;
    }
}