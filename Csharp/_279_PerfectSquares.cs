using System;

namespace Csharp
{
    public class _279_PerfectSquares
    {
        public int NumSquares(int n)
        {
            int[] dp = new int[n + 1];
            Array.Fill(dp, int.MaxValue);
            dp[0] = 0;
            for (int i = 1; i < dp.Length; i++)
            {
                for (int j = 1; j * j <= i; j++)
                {
                    dp[i] = Math.Min(dp[i], dp[i-j*j] + 1/*dp[j*j]*/);
                }
            }
            return dp[dp.Length-1];
        }
    }
}