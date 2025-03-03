class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String,Integer> frequencies = new HashMap<>();

        for(int i=0;i<matrix.length;i++){
            StringBuilder sb = new StringBuilder("1");
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==matrix[i][0]){
                    sb.append("1");
                }else{
                    sb.append("0");
                }
            }
            String pattern = sb.toString();
            frequencies.put(pattern,frequencies.getOrDefault(pattern, 0)+1);
        }

        int maxrow=0;
        for(String key : frequencies.keySet()){
            maxrow = Math.max(maxrow,frequencies.get(key));
        }
        return maxrow;
    }
}