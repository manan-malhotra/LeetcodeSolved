class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m==0 && n==0) return 0.0;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        if(n==0) {
            if(m%2==0) {
                return (nums2[m/2]+nums2[(m-1)/2])/2.0;
            }
            return nums2[m/2];
        }
        System.out.println("nums1 "+nums1[0]);
        int start = 0;
        int end = n;
        while(start<=end){
            int mid1 = start + (end-start)/2;
            int mid2= (n+m+1)/2 - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1!=0) l1 = nums1[mid1-1];
            if(mid2!=0) l2 = nums2[mid2-1];
            if(mid1!=n) r1 = nums1[mid1];
            if(mid2!=m) r2 = nums2[mid2];
            System.out.println("l1 "+l1);
            System.out.println("l2 "+l2);
            System.out.println("r1 "+r1);
            System.out.println("r2 "+r2);
            if(l1<=r2 && l2<=r1){
                //ans
                if((n+m)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                return (Math.max(l1,l2));
            }else if(l1>r2){
                end = mid1-1;
            }else{
                start = mid1+1;
            }


        }
        return 0.0;
    }
}