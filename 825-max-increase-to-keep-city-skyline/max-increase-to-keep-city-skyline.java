class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int maxrow[]=new int[n];
        int maxcol[]=new int[n];
        int add=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                maxrow[i]=Math.max(maxrow[i],grid[i][j]);
                maxcol[j]=Math.max(maxcol[j],grid[i][j]);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int newheight=Math.min(maxrow[i],maxcol[j]);
                add+=newheight-grid[i][j];
            }
        }
        return add;
    }
}