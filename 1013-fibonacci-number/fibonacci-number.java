class Solution {
    public int fib(int n) {
        if(n<2) return n;
        int first=0;
        int second=1;
        for(int i=2;i<=n;i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}