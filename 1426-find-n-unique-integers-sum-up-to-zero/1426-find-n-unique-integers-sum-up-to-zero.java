class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int mid = n/2;
        if(n%2==0){
            int num=-1;
            for(int i=mid-1;i>=0;i--){
                res[i]=num;
                num--;
            }
            num=1;
            for(int i=mid;i<n;i++){
                res[i]=num;
                num++;
            }
        }else{
            int num=-1;
            for(int i=mid-1;i>=0;i--){
                res[i]=num;
                num--;
            }
            num=1;
            for(int i=mid+1;i<n;i++){
                res[i]=num;
                num++;
            }
            res[mid]=0;
        }

        return res;
    }
}