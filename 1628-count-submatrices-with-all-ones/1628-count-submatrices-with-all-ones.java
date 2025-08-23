class Solution {
    public int numSubmat(int[][] mat) {
        int ans=0, m= mat.length, n = mat[0].length;
        
        for(int startRow=0;startRow<m;startRow++){
            int[] temp = new int[n];
            Arrays.fill(temp, 1);
            for(int endRow=startRow;endRow<m;endRow++){

                for(int col=0;col<n;col++){
                    temp[col] = temp[col] & mat[endRow][col];
                }

                ans += oneDimArrayCount(temp);
            }

        }
        return ans;
    }

    private int oneDimArrayCount(int[] arr){
        int cons=0,subCount=0;
        for(int e:arr){
            if(e==0){
                cons=0;
            }else{
                cons++;
            }
            subCount+=cons;
        }
        return subCount;
    }
}