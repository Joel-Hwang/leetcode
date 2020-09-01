using System;

namespace Csharp
{
    public class MedianOfTwoArrays
    {
        public MedianOfTwoArrays()
        {
            //Console.WriteLine(LengthOfLongestSubstring("asdasdasd"));
        }

        public double FindMedianSortedArrays(int[] A, int[] B)
        {
            int m = A.Length;
            int n = B.Length;
            if (m > n)
            {
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }

            int half = (m + n + 1) / 2;
            int iMin = 0;
            int iMax = m;
            while (iMin <= iMax)
            {
                int i = (iMin + iMax) / 2;
                int j = half - i;
                if (i < iMax && A[i] < B[j - 1])
                {
                    iMin = i + 1;
                }
                else if (i > iMin && A[i - 1] > B[j])
                {
                    iMax = i - 1;
                }
                else
                {
                    int maxLeft = 0;
                    if(i==0) maxLeft = B[j-1];
                    else if(j==0) maxLeft = A[i-1];
                    else maxLeft = Math.Max(A[i-1], B[j-1]);
                    if((m+n)%2 == 1) return maxLeft;

                    int minRight = 0;
                    if(i==m) minRight = B[j];
                    else if(j==n)minRight = A[i];
                    else minRight = Math.Min(A[i], B[j]);
                    return (maxLeft + minRight)/2.0;
                }
            }
            return 0.0;
        }
    }
}