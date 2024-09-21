class Solution {
    public int maxCoins(int[] piles) {
        int ans = 0;
        int i=1;
        int j= piles.length - 2;
        Arrays.sort(piles);
        for(int p : piles) System.out.print(p+" ");
        while(i<=j){
            ans+=piles[j];
            i++;
            j-=2;
        }
        return ans;
    }
}