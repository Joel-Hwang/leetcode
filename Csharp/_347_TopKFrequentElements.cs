using System;
using System.Collections.Generic;

namespace Csharp
{
    public class _347_TopKFrequentElements
    {
        public int[] TopKFrequent(int[] nums, int k)
        {
            Dictionary<int, int> frequent = new Dictionary<int, int>();
            for(int i = 0; i < nums.Length; i++){
                if(frequent.ContainsKey(nums[i]))
                    frequent[nums[i]] += 1;
                else frequent[nums[i]] = 1;
            }
            List<int[]> frequentList = new List<int[]>();
            foreach(KeyValuePair<int, int> kvp in frequent){
                frequentList.Add(new int[]{kvp.Key, kvp.Value});
            }

            frequentList.Sort((a,b) => b[1] - a[1]);

            int[] res = new int[k];
            for(int i = 0; i<k; i++){
                res[i] = frequentList[i][0];
            }
            return res;
        }
    }
}