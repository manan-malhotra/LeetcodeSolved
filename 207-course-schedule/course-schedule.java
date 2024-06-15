class Solution {
    public boolean canFinish(int n, int[][] pre) {
      
        boolean visited[] = new boolean[n]; 
        boolean helper[] = new boolean[n];     
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
        {
            al.add(new ArrayList());
        }
        
        for(int[] t: pre)
        {
            al.get( t[1] ).add( t[0] );
        }
        
        for(int i = 0; i < n; i++)
        {   
            if(visited[i] == false)
            {
                boolean ans = dfs_cyclicDetection(al, i , visited , helper);
                if(ans)
                return false;
            }     
        }
        return true;
    }
    
    public static boolean dfs_cyclicDetection( ArrayList<ArrayList<Integer>> al, int i,  boolean visited[],  boolean helper[]) {
        
        visited[i] = true;
        helper[i] = true; 
        ArrayList< Integer > neighbour = al.get(i);
        
        for(int k = 0; k < neighbour.size(); k++)
        {
            int curr = neighbour.get(k);
            if(helper[curr] == true) return true;
            
            if(visited[curr] == false)
            {
                boolean ans = dfs_cyclicDetection(al,curr,visited,helper);
                if(ans == true) return true;
            }
        }
		
        helper[i] = false;  
        return false;
    }
}