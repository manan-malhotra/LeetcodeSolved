class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if (startColor == color)
            return image;
        int n = image.length;
        int m = image[0].length;
        dfs(image, sr, sc, n, m, startColor, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int n, int m, int startColor, int color){
        if(sr<0 || sc<0 || sr>=n || sc>=m || image[sr][sc]!=startColor) return;
        image[sr][sc] = color;
        int[][] traverse ={
        {0,1},{0,-1},{1,0},{-1,0}
        };
        for(int i=0;i<4;i++){
            dfs(image,sr+traverse[i][0],sc+traverse[i][1],n,m,startColor,color);
        }
    }
}