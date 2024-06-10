class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tri> pq = new PriorityQueue<Tri>((x,y)->y.dist-x.dist);
        for(int[] arr:points){
            Tri temp = new Tri(arr[0],arr[1]);
            pq.offer(temp);
            if(pq.size()>k) pq.poll();
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            Tri temp = pq.poll();
            ans[i][0] = temp.x;
            ans[i++][1]=temp.y;
        }
        return ans;
    }
}
class Tri {
        int x;
        int y;
        int dist;

        Tri(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (x*x)+(y*y);
        }
}