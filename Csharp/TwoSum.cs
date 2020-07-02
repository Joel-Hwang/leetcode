using System.Collections;
using System.Collections.Generic;

namespace Csharp
{
    public class Solution
    {
        public int[] TwoSum(int[] nums, int target)
        {
            Hashtable hashtable = new Hashtable();
            for (int i = 0; i < nums.Length; i++)
            {
                if (hashtable.ContainsKey(target - nums[i]))
                {
                    return new int[] { (int)(hashtable[(target - nums[i])]), i };
                }
                else if(hashtable.ContainsKey(nums[i]))
                {
                    hashtable[nums[i]] = i;
                }
                else
                {
                    hashtable.Add(nums[i], i);
                }
            }

            return null;
        }

        public int[] TwoSum2(int[] nums, int target)
        {
            Dictionary<int,int> dictionary = new Dictionary<int, int>();
            
            for (int i = 0; i < nums.Length; i++)
            {
                if (dictionary.ContainsKey(target - nums[i]))
                {
                    return new int[] { dictionary[(target - nums[i])], i };
                }
                else if(dictionary.ContainsKey(nums[i]))
                {
                    dictionary[nums[i]] = i;
                }
                else
                {
                    dictionary.Add(nums[i], i);
                }
            }

            return null;
        }
    }
}
