class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int left=0,top=0,right=m-1,bottom=n-1;
        List<Integer> ans = new ArrayList<>();

        int itr = 0;

        while(ans.size() < n*m){
            //top row
            for(int i=left;i<=right;i++){
                if(ans.size() == n*m)
                    return ans;
                ans.add(matrix[top][i]);
            }
            top++;
           

            //right col
            for(int i=top;i<=bottom;i++){
                if(ans.size() == n*m)
                    return ans;
                ans.add(matrix[i][right]);
            }
            right--;
                        
            //bottom row
            for(int i=right;i>=left;i--){
                if(ans.size() == n*m)
                    return ans;
                ans.add(matrix[bottom][i]);
            }
            bottom--;
           
            //left col
            for(int i=bottom;i>=top;i--){
                if(ans.size() == n*m)
                    return ans;
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}