class Solution {
    public double separateSquares(int[][] squares) {
        double low=0.0, high = 0.0, totalArea=0.0;

        for(int[] coordinate : squares){
            double y = coordinate[1];
            double l = coordinate[2];
            high = Math.max(high, y+l);
            totalArea += l*l;
        } 

        double pow = 1e-5,ans=high;

        while(Math.abs(high-low) > pow){
            double midY = (low+high)/2.0;
            if(isPossible(midY, squares, totalArea)){
                ans=midY;
                high = midY;
            }else{
                low=midY;
            }
        }

        return ans;
    }

    private boolean isPossible(double midY, int[][] squares, double totalArea){
        double bottomArea=0.0;

        for(int[] coordinate : squares){
            int y1 = coordinate[1];
            int y2 = y1+coordinate[2];
            int l = coordinate[2];

            if(y2 <= midY){
                bottomArea += (double)l*l;
            }else if(y1 < midY){
                bottomArea += (double)(midY-y1)*l;
            }
        } 

        return bottomArea >= totalArea/2.0;
    }
}