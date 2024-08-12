class Solution {
    public boolean exist(char[][] board, String word) {
        boolean present = false;
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    present = isWordPresent(board,word,i,j,0,n,m);
                    if(present)
                        return present;
                }
            }
        }
        return present;
    }

    public boolean isWordPresent(char[][] board, String word, int r, int c, int idx, int n, int m){

        //base condn
        if(idx>=word.length()){
            return true;
        }
        if(r<0 || r >= n || c < 0 || c >= m || board[r][c] != word.charAt(idx)) return false;

        char ch = board[r][c];
        board[r][c]='*';

        //up
        boolean up = isWordPresent(board,word,r-1,c,idx+1,n,m);

        //left
        boolean left = isWordPresent(board,word,r,c-1,idx+1,n,m);

        //right
        boolean right = isWordPresent(board,word,r,c+1,idx+1,n,m);

        //down
        boolean down = isWordPresent(board,word,r+1,c,idx+1,n,m);

        if(up == false && left == false && right == false && down == false){
            board[r][c]=ch;
            return false;
        }

        return true;

    }
}