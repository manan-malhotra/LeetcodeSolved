class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int oldColor = image[sr][sc];
        dfs(sr,sc,color,oldColor,image);
        return image;
    }
    public void dfs(int row, int col, int color, int oldColor, int[][] image){
        if(row<0 || col<0 || row>=image.length || col>=image[0].length || image[row][col]!=oldColor) return;
        image[row][col] = color;
        dfs(row+1,col,color,oldColor,image);
        dfs(row-1,col,color,oldColor,image);
        dfs(row,col-1,color,oldColor,image);
        dfs(row,col+1,color,oldColor,image);
    }
}