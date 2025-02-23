class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count=0;
        Arrays.sort(banned);
        for(int num=1;num<=n;num++){
            if(!isNumberBanned(banned,num)){
                maxSum -= num;
                if(maxSum<0){
                    break;
                }
                count++;
            }
        }
        return count;
    }

    private boolean isNumberBanned(int[] banned, int target){
        int left = 0,right = banned.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(banned[mid] == target) return true;
            if(banned[mid] > target){
                right=mid-1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}