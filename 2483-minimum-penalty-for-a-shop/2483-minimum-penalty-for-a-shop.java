class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixTime = new int[n+1];

        char[] arr = customers.toCharArray();
        int penality=0;
        for(char c : arr){
            if(c == 'N'){
                penality++;
            }
        }

        prefixTime[n] = penality;
        int mini = penality,idx=n;
        for(int i=n-1;i>=0;i--){
            if(arr[i]=='Y'){
                prefixTime[i] = prefixTime[i+1]+1;
            }else{
                prefixTime[i] = prefixTime[i+1]-1;
            }
            if(mini >= prefixTime[i]){
                mini = prefixTime[i];
                idx=i;
            }
        }
        return idx;

        
    }
}