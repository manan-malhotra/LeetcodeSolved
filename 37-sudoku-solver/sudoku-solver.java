class Solution {

    public boolean isSafe(char[][] board ,int val , int row, int col)
        {
            for(int i=0;i<board.length;i++)
            {
                if(board[row][i] == (char)(val+'0'))
                {
                    return false;
                }
            }

            for(int j = 0;j<board.length;j++)
            {
                if(board[j][col] == (char)(val+'0'))
                    return false;
            }

            int sr = row/3 * 3;
            int sc = col/3 * 3;

            for(int i = sr ;i<sr+3 ;i++)
            {
             for(int j = sc ; j<sc+3;j++)
             {
                 if(board[i][j] == (char)(val+'0'))
                 {
                     return false;
                 }
             }
            }
return true;
        }

    public boolean helper(char[][] board, int row, int col)
    {
        if(row == board.length)
            return true;
        int nrow = 0 , ncol = 0 ; 
        if(col == board.length-1)
        {
            nrow = row+1;
            ncol = 0;
        }
        else
        {
            nrow = row;
            ncol = col+1;
        }

        if(board[row][col] != '.')
        {
            if(helper(board,nrow,ncol))
                return true;
        }
        else
        {
            for(int i=1;i<=9;i++)
            {
                if(isSafe(board,i,row,col))
                {
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol))
                        return true;
                    else
                    {
                        board[row][col] = '.';
                    }
                }
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}