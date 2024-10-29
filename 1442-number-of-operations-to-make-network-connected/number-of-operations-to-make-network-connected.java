class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m<n-1) return -1;
        Disjoint dsu = new Disjoint(n);
        for(int[] edge : connections){
            dsu.union(edge[0],edge[1]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(dsu.findUPar(i)==i) count++;
        }
        return count-1;
    }
}
class Disjoint{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public Disjoint(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        int parentNode = parent.get(node);
        if(parentNode == node) return node;
        parentNode = findUPar(parentNode);
        parent.set(node,parentNode);
        return parentNode;
    }
    public void union(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v) return;
        int sizeU = size.get(ulp_u);
        int sizeV = size.get(ulp_v);
        if(sizeU<sizeV){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,sizeU+sizeV);
        }else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,sizeU+sizeV);
        }
    }
}