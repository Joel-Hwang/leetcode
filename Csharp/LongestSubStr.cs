using System;
using System.Collections.Generic;

namespace Csharp
{
    public class LongestSubStr
    {
        public LongestSubStr()
        {
            Console.WriteLine(LengthOfLongestSubstring("asdasdasd"));
        }

        public int LengthOfLongestSubstring(string s)
        {
            int n = s.Length;
            int i = 0, j = 0, ans = 0;
            HashSet<char> set = new HashSet<char>();
            while(i<n && j<n){
                if(!set.Contains(s[j])){
                    set.Add(s[j++]);
                    ans = Math.Max(ans,j-i);
                }else{
                    set.Remove(s[i++]);
                }
            }
            return ans;
        }
    }
}