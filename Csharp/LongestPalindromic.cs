using System;

namespace Csharp
{
    public class LongestPalindromic
    {
         public LongestPalindromic()
        {
            Console.WriteLine(LongestPalindrome("babad"));
        }

        public string LongestPalindrome(string s)
        {
            if(s == null || s.Length <1) return "";
            int start = 0, end=0;
            for(int i = 0; i<s.Length; i++){
                int len1 = explandAroundCenter(s,i,i);
                int len2 = explandAroundCenter(s, i, i+1);
                int len = Math.Max(len1, len2);
                if(len > end-start){
                    start = i - (len-1)/2;
                    end = i + len/2;
                }
            }

            return s.Substring(start, end-start+1);
        }

        private int explandAroundCenter(string s, int L, int R){
            while(L >=0 && R < s.Length && s[L] == s[R]){
                L--;
                R++;
            }
            return R-L-1;
        }
    }
}