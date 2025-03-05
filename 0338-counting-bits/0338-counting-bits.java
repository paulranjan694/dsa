class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int num=0;num<=n;num++){
            int count=0;
            int x = num;
            while(x>0){
                x = x & (x-1);
                count++;
            }
            ans[num] = count;
        }
        return ans;
    }
}