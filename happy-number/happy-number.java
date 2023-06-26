class Solution {
    public boolean isHappy(int n) {
        int s = n,f = n; // slow , fast
        
        do{
            s = compute(s); // slow computes only once
            f = compute(compute(f)); // fast computes 2 times
            
            if(s == 1)return true; // if we found 1 then happy indeed !!!
        }while(s != f); // else at some point they will meet in the cycle
        
        return false; // it's a cycle , not happy at all !!!        
    }
    public int compute(int n){
        int s = 0;
        while(n != 0){
            s += (n%10)*(n%10);
            n = n/10;
        }
        return s;
    }
}