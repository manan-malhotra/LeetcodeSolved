class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            System.out.println(slow);
            if(slow==1){
                return true;
            }
        }while(slow!=fast);
        return false;
        
    }
    public int findSquare(int n){
        int square = 0;
        while(n!=0){
            square += (n%10)*(n%10);
            n=n/10;
        }
        return square;
    }
}