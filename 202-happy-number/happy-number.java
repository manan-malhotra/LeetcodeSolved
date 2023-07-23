class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            if(fast==1){
                return true;
            }
        }while(slow!=fast);
        return false;
        
    }
    public int findSquare(int n){
        int square = 0;
        while(n!=0){
            int temp = n%10;
            n=n/10;
            square += temp*temp;
        }
        return square;
    }
}