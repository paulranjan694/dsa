class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        
        int[] leftScore = new int[n];
        int[] rightScore = new int[n];
        
        Arrays.fill(leftScore,1);
        Arrays.fill(rightScore,1);
        
        
        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                leftScore[i] = leftScore[i-1] +1;
            }
        }
        
        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                rightScore[i] = rightScore[i+1] +1;
            }
        }
        
        int minCandy = 0;
        for(int i=0;i<n;i++){
            minCandy += Math.max(leftScore[i],rightScore[i]);
        }
        return minCandy;
    }
}