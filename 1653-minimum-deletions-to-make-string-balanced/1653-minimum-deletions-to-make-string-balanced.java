class Solution {
    public int minimumDeletions(String s) {
        int n = s.length(), countA=0,countB=0;
        int[] prefixB = new int[n], suffixA = new int[n];
        char[] arr = s.toCharArray();
        for(int i=0;i<n;i++){
            prefixB[i] = countB;
            if(arr[i] == 'b') countB++;
        }

        for(int i=n-1;i>=0;i--){
            suffixA[i] = countA;
            if(arr[i] == 'a') countA++;
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, prefixB[i]+suffixA[i]);
        }
        return min;
    }
}