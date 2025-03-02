class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid[0].length;
        int count=0,countIndex = n-1;
        for(int[] row:grid){
            while(countIndex >= 0 && row[countIndex] < 0){
                countIndex--;
            }
            count += n - (countIndex + 1);
        }
        return count; 
    }
}