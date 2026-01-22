class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> {
            if(a[1]==b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

        int len=0, n=pairs.length, curr = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pairs[i][0] > curr){
                len++;
                curr = pairs[i][1];
            }
        }
        return len;
    }
}