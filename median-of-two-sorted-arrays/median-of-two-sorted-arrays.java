class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m= nums2.length;
        if(n==0 && m==0) return 0.0;
        if(n>m) return findMedianSortedArrays(nums2, nums1);
        if(n==0){
            if(m%2==0){
                return (nums2[m/2]+nums2[(m-1)/2])/2.0;
            }
            System.out.println("test");
            return nums2[m/2];
        }
        
        int start = 0;
        int end = n;
        int total = n+m+1;

        while(start<=end){
            int mid1 = start + (end-start)/2;
            int mid2 = (total/2) - mid1;
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;
            if(mid1!=0) left1 = nums1[mid1-1];
            if(mid2!=0) left2 = nums2[mid2-1];
            if(mid1!=n) right1 = nums1[mid1];
            if(mid2!=m) right2 = nums2[mid2];

            if(left1<=right2 && left2<=right1){
                if((total-1)%2==0){
                    return (Math.max(left1, left2)+Math.min(right1, right2))/2.0;
                }
                return Math.max(left1, left2);
            }else if(left1>right2){
                end = mid1-1;
            }else{
                start = mid1+1;
            }

        }
        return 0.0;
    }
}