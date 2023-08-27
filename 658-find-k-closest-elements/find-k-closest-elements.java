class Solution {
            public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return adde(A,left,left+k);
        // Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }
        public List<Integer> adde(int[] arr, int l, int r){
            List<Integer> a = new ArrayList<Integer>();
            for(int i=l;i<r;i++) a.add(arr[i]);
            return a;
        }
}