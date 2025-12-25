class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Integer[] arr = new Integer[n];

        for(int i=0;i<n;i++){
            arr[i] = happiness[i];
        }

        Arrays.sort(arr, (Integer a, Integer b) -> Integer.compare(b, a));

        long ans=0;
        int pick=0;
        while(k>0){
            
            ans += Math.max(arr[pick] - pick,0);
            pick++;
            k--;
        }

        
        return ans;
    }
}