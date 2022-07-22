using System;
using System.Collections.Generic;

namespace Csharp
{
    public class _1959_MinimumTotalSpaceWastedWithKResizingOperations {
        public int MinSpaceWastedKResizing(int[] nums, int k) {
            int[][] memeories = new int[200][];
            for(int i = 0; i < memeories.Length; i++){
                memeories[i] = new int[200];
                for(int j = 0; j < memeories[i].Length; j++)
                    memeories[i][j] = -1;
            }
            return dp(nums,memeories,0,k);
        }

        private int dp(int[] nums, int[][] memories, int i, int k){
            if(i == nums.Length ) return 0;
            if(k < 0) return 200000000;
            if(memories[i][k] >= 0) return memories[i][k]; 

            int ans = 200000000;
            int max = nums[i];
            int sum = 0;
            for(int j = i; j<nums.Length; j++){
                max = Math.Max(max,nums[j]);
                sum += nums[j];
                int waste = max*(j-i+1) - sum;
                ans = Math.Min(ans,waste + dp(nums,memories,j+1,k-1));
            } 

            memories[i][k] = ans;
            return ans;
        }
    }
}