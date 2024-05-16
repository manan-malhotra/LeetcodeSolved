class Solution {
    public int reachNumber(int target) {
        
		//convert negative target to positive
        if(target<0){
            target*=-1;
        }
        
        int start = 1;
        int end = target; 
        int numMoves = 0;
        long finalPosition = 0;
        
        while(start<=end){
            int mid = start+(end-start)/2;
			
			// here we consider n = mid then n*(n+1)/2 becomes mid*(mid+1)/2
            long sum = (long)mid*(mid+1)/2;
            
			
            if(sum>=target){
			//if difference is even direct binary search
                finalPosition = sum;
                numMoves = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
              }
          }
            
        int difference = (int)(finalPosition - target);
                //if difference is odd
                if(difference%2!=0){
                    
					//if n+1 is odd
                    if((numMoves+1)%2!=0){
                        numMoves+=1;
                    }
                    else{
					//if n+1 is even, then n+2 is odd
                        numMoves+=2;
                    }  
                }
     return numMoves;           
    }        
}