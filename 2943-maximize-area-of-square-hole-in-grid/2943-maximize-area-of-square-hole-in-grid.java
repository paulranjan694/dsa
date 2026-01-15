class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int longHBars = 1, longVBars=1;

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int tempLen=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i] == hBars[i-1] + 1){
                tempLen++;
            }else{
                tempLen=1;
            }
            longHBars = Math.max(longHBars, tempLen);
        }

        tempLen=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i] == vBars[i-1] + 1){
                tempLen++;
            }else{
                tempLen=1;
            }
            longVBars = Math.max(longVBars, tempLen);
        }

        int len = Math.min(longHBars, longVBars) + 1;

        return len * len;
    }
}