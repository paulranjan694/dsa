class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left=1,right=position[n-1]-position[0], minDistance = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(position,m,mid)){
                minDistance=mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return minDistance;
    }

    private boolean isPossible(int[] position, int m, int minDist){
        int count=1,n=position.length,pos=position[0];
        for(int i=1;i<n;i++){
            if(position[i] - pos>= minDist){
                count++;
                pos=position[i];
            }
            if(count==m) return true;
        }

        return false;
    }
}