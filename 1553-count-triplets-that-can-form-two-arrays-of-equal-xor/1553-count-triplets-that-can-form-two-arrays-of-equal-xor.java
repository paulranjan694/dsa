class Solution {
    public int countTriplets(int[] arr) {
        int ans=0,a=0,b=0,n=arr.length;

        for(int i=0;i<n-1;i++){
            a=0;
            for(int j=i+1;j<n;j++){
                a ^= arr[j-1];
                b=0;
                for(int k=j;k<n;k++){
                    b ^= arr[k];
                    if(a==b){
                        //System.out.println(i+"--"+j+"--"+k);
                        ans++;
                    } 
                }
            }
        }
        return ans;

    }
}