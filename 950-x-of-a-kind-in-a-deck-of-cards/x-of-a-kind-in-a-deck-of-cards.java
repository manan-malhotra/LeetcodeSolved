class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:deck){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int freq = hm.get(deck[0]);
        for(int frequencies : hm.values()){
            freq = gcd(freq,frequencies);

        }
        return freq!=1;
    }
    int gcd(int x, int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
}


