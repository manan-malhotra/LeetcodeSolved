class Solution {

    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];

        if(board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        }

        helper(board, i, j);

        return board;
    }

    private void helper(char[][] board, int i, int j){
        int count = 0;

        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;

            if(board[x][y] == 'M') count++;
        }

        board[i][j] = (count > 0) ? (char)(count + '0') : 'B';

        if(board[i][j] == 'B'){
            for(int[] dir : dirs){
                int x = i + dir[0];
                int y = j + dir[1];
    
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') continue;
    
                helper(board, x, y);
            }
        }
    }
}