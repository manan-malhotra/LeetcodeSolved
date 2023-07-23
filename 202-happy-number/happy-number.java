class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while(replace(fast)!=1 || replace(replace(fast)) !=1){
            fast=replace(replace(fast));
            slow=replace(slow);
            if(slow==fast) return false;
        }
        
        return true;
        
        
    }
    public int replace(int n){
        int square=0;
        while(n!=0){
            int rem = n%10;
            square += rem*rem;
            n=n/10;
        }
        return square;
    }
}