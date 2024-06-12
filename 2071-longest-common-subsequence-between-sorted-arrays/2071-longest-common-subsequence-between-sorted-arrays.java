class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] arr = new int[101];
        int n = arrays.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<arrays[i].length;j++){
                arr[arrays[i][j]]++;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n) ans.add(i);
        }

        return ans;


    }
}