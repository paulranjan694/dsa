class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length,ans=0;
        int[] prefixXor = new int[n+1];

        for(int i=1;i<=n;i++){
            prefixXor[i] = prefixXor[i-1]^arr[i-1];
        }

        for(int i=0;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(prefixXor[i] == prefixXor[j]){
                    ans += (j-i-1);
                }
            }
        }
        return ans;
    }
}