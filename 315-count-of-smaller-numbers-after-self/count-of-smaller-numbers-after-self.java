/*
* Idea: 
* Keep a sorted array of numbers. 
* Start visiting the numbers from back, and perform binary search on 
* the currently visited and sorted numbers, to find the insertion point 
* Once we find the insertion point we know exactly that many number of 
* elements are smaller in the currently visited array. 
*
* Example:
* 1. [5,2,6,1] Sorted And Visited: [] (no element)
* 2. First element is 1, the insertion point in the second array is 0, 
*    thus we know 0 elements are lesser than 1 till now, Sorted And Visited: [1]
* 3. Next element 6, insertion position 1, thus 1 element is smaller till now,  Sorted And Visited: [1,6]
* 4. Next element 2, insertion position 1, thus 1 element is smaller till now,  Sorted And Visited: [1,2,6]
* 5. Next element 5, insertion position 2, thus 2 element is smaller till now,  Sorted And Visited: [1,2,5,6]
*/

class Solution {
    public List countSmaller(int[] nums) {
        List<Integer> sortedAndVisited = new ArrayList<>();
        
        int[] arr = new int[nums.length];
        
        // Start visiting the numbers from back
        for(int i = (nums.length-1); i >= 0; i--){
            // Keep in mind this array is getting filled from back
            arr[i] = 
                binarySearchAndInsert(
                    nums[i], 0, sortedAndVisited.size(), sortedAndVisited);
        }
        
        List<Integer> output = new ArrayList<>();
        for(int i=0; i < arr.length; i++) {
            output.add(arr[i]);
        }

        return output;
    }
    
    public int binarySearchAndInsert(int currentNo, int low, int high, List<Integer> sortedAndVisited){
        //binary search to find out sorted position of element
        int mid = low + (high - low)/2;
        
        // End of search and we found the position
        if(low >= high){
            sortedAndVisited.add(mid, currentNo);
            return mid;
        }
        
        if(currentNo <= sortedAndVisited.get(mid)){
            return binarySearchAndInsert(currentNo, low, mid, sortedAndVisited);
        }else{
            return binarySearchAndInsert(currentNo, mid + 1, high, sortedAndVisited);
        }

    }
}