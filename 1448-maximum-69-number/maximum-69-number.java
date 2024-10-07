class Solution {
    public int maximum69Number (int num) {
        int add = 0;
        int six = 3;
        boolean check = false;
        int n = num;
        while(n!=0){
            int rem = n%10;
            n/=10;
            if(rem==6){
                add = six;
            }
            six*=10;
        }
        return num+add;
    }
}