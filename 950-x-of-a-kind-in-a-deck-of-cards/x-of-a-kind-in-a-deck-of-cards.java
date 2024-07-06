class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:deck){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int freq = hm.get(deck[0]);
        for(int frequencies : hm.values()){
            freq = hcf(freq,frequencies);

        }
        return freq!=1;
    }
    int hcf(int x, int y){
        if(y==0) return x;
        return hcf(y,x%y);
    }
}