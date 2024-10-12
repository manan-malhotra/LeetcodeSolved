class Solution {
    public boolean divisorGame(int n) {
        int count = 0;
        int i = 1;
        while(i*i<n){
            if(n>1){
                if(n%i == 0){
                    n = n - i;
                    count++;
                    i = 1;
                }
            }else{
                i++;
            }
        }
        if(count%2 == 0){
            return false;
        }
        return true;
    }
}