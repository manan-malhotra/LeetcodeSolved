/*
    If it was needed to find the minimum time to reach vertex n from vertex 1, 
	we would have done a simple BFS and stored the minimum time to reach each vertex. 
	Here we need to find the second minimum time, so basically, we need to reach each vertex 
	at most twice and store the minimum and second minimum time to reach every vertex. 
	Note: second minimum time should be strictly greater than the minimum time. 
	We can apply the same BFS with modification that we reach every vertex for the second time 
	and the second arriving time should be strictly greater than the first arriving time.
*/
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {    
        
        // creating the graph
        List<Integer> list[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            list[i]=new ArrayList<>();
        for(int []e:edges){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        // for each vertex we store two arriving times.
        long [][]dist=new long [n+1][2];
        for(long []I:dist)
            Arrays.fill(I,Long.MAX_VALUE);
                
        Queue<Duo> q=new LinkedList<>();
        
        // we start from vertex 1.
        q.offer(new Duo(1,0l));
        dist[1][0]=0; 
        
        Duo p;
        long val,wait;
        while(q.size()>0){           
            p=q.poll();
            
            /*
                Calculation for the arriving time to the adjacent vertex:
                We have reached the current vertex p.idx at time p.val.
                Now, we need to find out the current state of the traffic light.
                Number of changes in traffic light=(p.val/change).
                If number of changes is odd, starting from green, 
				the current state will be red and vice versa.
                If the current state is red, we need to wait for it to become green(another change) to leave the vertex.
                waiting time=change-(p.val%change);
                If the current state is green, we can instantly leave the vertex, 
                waiting time=0.
            */
            wait=0l;
            if((p.val/change)%2==1){
                wait=change-(p.val%change);
            }                
            val=p.val+wait+(long)time; // time to reach adjacent node from the current node.
            
            for(int i:list[p.idx]){
                
                if(dist[i][0]>val){
                    // arriving for the first time to this node.
                    dist[i][0]=val;
                    q.offer(new Duo(i,val));
                }
                
                else if(val>dist[i][0]&&dist[i][1]>val){
                    // arriving for the second time to this node with second arriving time strictly greater than the first arriving time.
                    
                    if(i==n) // returning the answer
                        return (int)val;
                    
                    dist[i][1]=val;
                    q.offer(new Duo(i,val));
                }  
                
            }
        }
        return -1;
    }
}
class Duo{
    int idx;
    long val;
    Duo(int i, long v){
        idx=i;
        val=v;
    }
}