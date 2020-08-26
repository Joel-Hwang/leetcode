public class MedianOfTwoArrays {

    public MedianOfTwoArrays(){
        double result = this.findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }

        int half = (m+n+1)/2;
        int iMin = 0; 
        int iMax = m;
        while(iMin <= iMax){
            int i = (iMin + iMax)/2;
            int j = half - i;
            if(i < iMax && A[i] < B[j-1] ){
                iMin = i+1;
            }else if(i > iMin && A[i-1] > B[j]){
                iMax = i-1;
            }else{
                int maxLeft = 0;
                if(i==0) maxLeft = B[j-1];
                else if(j==0)maxLeft = A[i-1];
                else maxLeft = Math.max(A[i-1], B[j-1]);
                if( (m+n)%2 == 1 ) return maxLeft;

                int minRight = 0;
                if(i == m) minRight = B[j];
                else if(j == n) minRight = A[i];
                else minRight = Math.min(A[i],B[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }


    /*
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }*/

/*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2] ) {
                med2 = nums1[index1];
                index1++;
            }  else {
                med2 = nums2[index2];
                index2++;
            }
        }
    
        // the median is the average of two numbers
        if ((nums1.length+nums2.length)%2 == 0) {
            return (float)(med1+med2)/2;
        }
    
        return med2;
    }*/



}