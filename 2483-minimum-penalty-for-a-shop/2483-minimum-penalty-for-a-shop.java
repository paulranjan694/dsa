class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        //int[] prefixTime = new int[n+1];

        char[] arr = customers.toCharArray();
        int penality=0;
        for(char c : arr){
            if(c == 'N'){
                penality++;
            }
        }

        
        int mini = penality,idx=n;
        for(int i=n-1;i>=0;i--){
            if(arr[i]=='Y'){
                penality = penality+1;
            }else{
                penality = penality-1;
            }
            if(mini >= penality){
                mini = penality;
                idx=i;
            }
        }
        return idx;

        
    }
}