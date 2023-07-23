/**
 * The Solution class contains a method isHappy that determines if a given number is a happy number.
 */

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
       // The code snippet is implementing the Floyd's cycle-finding algorithm to determine if a given
       // number is a happy number.
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
        // The code snippet is calculating the sum of the squares of the digits of a given number.
        int square = 0;
        while(n!=0){
            int temp = n%10;
            n=n/10;
            square += temp*temp;
        }
        return square;
    }
}