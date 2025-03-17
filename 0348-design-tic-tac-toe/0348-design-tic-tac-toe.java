class TicTacToe {
    int[][] board;
    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return findWinner();
    }

    private int findWinner(){
        int n = board.length;
        int[][] mat=board;
        for(int row = 0;row<board.length;row++){
            boolean gotwinner = true;
            for(int col = 1;col<board[row].length;col++){
                if(board[row][0] != board[row][col]){
                    gotwinner=false;
                    break;
                }
            }
            if(gotwinner){
                return board[row][0];
            }
        }

        for(int col = 0;col<board.length;col++){
            boolean gotwinner = true;
            int tempval = board[0][col];
            for(int row = 0;row<board.length;row++){
                if(tempval != board[row][col]){
                    gotwinner=false;
                    break;
                }
            }
            if(gotwinner){
                return board[0][col];
            }
        }

        int val = board[0][0];
        boolean gotwinner = true;
        for(int row = 1,col=1;row<board.length&&col<board[0].length;row++,col++){
            if(board[row][col] != val){
                gotwinner=false;
                break;
            }
        }
        if(gotwinner){
            return val;
        }

        val = board[0][n-1];
        gotwinner = true;
        for(int row = 1,col=n-2;row<board.length && col>=0;row++,col--){
            if(board[row][col] != val){
                gotwinner=false;
                break;
            }
        }
        
        if(gotwinner){
            return val;
        }


        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */