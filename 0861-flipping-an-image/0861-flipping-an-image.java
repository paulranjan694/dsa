class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<image[i].length;j++){
                if((image[i][j] & 1) == 1){
                    image[i][j]=0;
                }else{
                    image[i][j]=1;
                }
            }
        }

        int left=0,right=n-1;
        while(left<right){
            for(int i=0;i<n;i++){
                int t = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = t;
            }
            left++;right--;
        }

        return image;
    }
}