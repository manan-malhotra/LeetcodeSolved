class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int one = 1;
        int two = 2;
        int temp = 0;
        for(int i=3;i<=n;i++){
            temp = one+two;
            one = two ;
            two=temp;
        }
        return temp;
    }
}