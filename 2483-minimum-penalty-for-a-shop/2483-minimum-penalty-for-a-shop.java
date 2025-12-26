class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        //int[] prefixTime = new int[n+1];

        //char[] arr = customers.toCharArray();
        int penality=0;
        for(int i=0;i<customers.length();i++){
            char c = customers.charAt(i);
            if(c == 'N'){
                penality++;
            }
        }

        
        int mini = penality,idx=n;
        for(int i=n-1;i>=0;i--){
            char c = customers.charAt(i);
            if(c=='Y'){
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