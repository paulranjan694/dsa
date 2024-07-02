class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        int len = flowerbed.length;
       if(len==1 && flowerbed[0]==0 && n==1) return true;
        for(int i=0;i < len;i++){
            boolean isPossible = false;
            if(flowerbed[i]==0){
                if(i==0 && i+1 < len && flowerbed[i+1] == 0){
                    isPossible=true;
                }else if(i==len-1 && i-1>=0  && flowerbed[i-1] == 0){
                   isPossible=true;
                }else{
                    if(i+1<len && i-1>=0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0){
                        isPossible=true;
                    }
                }
            }
            if(isPossible){
                n--;
                flowerbed[i] = 1;
            }

            if(n==0)
                break;
        }

        if(n==0)
            return true;
        return false;

    }
}