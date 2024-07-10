class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] visitedPac = new int[r][c];
        int[][] visitedAlt = new int[r][c];
        
        for(int i = 0; i < c; i++){
            if(visitedPac[0][i] == 0){
                dfs(heights, visitedPac, 0, i);
            }
        }
        for(int i = 0; i < r; i++){
            if(visitedPac[i][0] == 0){
                dfs(heights, visitedPac, i, 0);
            }
        }
        for(int i = 0; i < c; i++){
            if(visitedAlt[r-1][i] == 0){
                dfs(heights, visitedAlt, r-1, i);
            }
        }
        for(int i = 0; i < r; i++){
            if(visitedAlt[i][c-1] == 0){
                dfs(heights, visitedAlt, i, c-1);
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(visitedPac[i][j] == 1 && visitedAlt[i][j] == 1){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    res.add(al);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] heights, int[][] visited, int i, int j){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length){
            return;
        }
        
        visited[i][j] = 1;
        int r = heights.length;
        int c = heights[0].length;
        if(i+1 < r && heights[i+1][j] >= heights[i][j] && visited[i+1][j] == 0){
            dfs(heights, visited, i+1, j);
        }
        if(j+1 < c && heights[i][j+1] >= heights[i][j] && visited[i][j+1] == 0){
            dfs(heights, visited, i, j+1);
        }
        if(i-1 >= 0 && heights[i-1][j] >= heights[i][j] && visited[i-1][j] == 0){
            dfs(heights, visited, i-1, j);
        }
        if(j-1 >= 0 && heights[i][j-1] >= heights[i][j] && visited[i][j-1] == 0){
            dfs(heights, visited, i, j-1);
        }
    }
}