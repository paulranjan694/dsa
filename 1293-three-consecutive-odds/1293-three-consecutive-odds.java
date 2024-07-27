class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3) return false;
        int sum=0;
        boolean isOdd = true;
        for(int i=0;i<3;i++){
           if(arr[i]%2==0){
                isOdd = isOdd && false;
           }
        }
        if(isOdd)
            return true;

        for(int k=1,i=3;i<arr.length;i++,k++){
            isOdd = true;
            for(int j=k;j<i;j++){
                if(arr[j]%2==0){
                    isOdd = isOdd && false;
                }
            }
            if(isOdd)
                return true;
        }
        return false;
    }
}