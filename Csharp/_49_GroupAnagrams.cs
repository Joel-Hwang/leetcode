using System;
using System.Collections.Generic;

namespace Csharp
{
    public class _49_GroupAnagrams
    {
        public IList<IList<string>> GroupAnagrams(string[] strs) {
            Dictionary<string, IList<string>> dic = new Dictionary<string, IList<string>>();
            foreach(string s in strs){
                string sorted = sort(s);
                if(!dic.ContainsKey(sorted))
                    dic[sorted] = new List<string>();
                dic[sorted].Add(s);
            }
            
            IList<IList<string>> res = new List<IList<string>>();
            foreach(KeyValuePair<string,IList<string>> kvp in dic){
                res.Add(kvp.Value);
            }
            return res;    
        }

        public IList<IList<string>> GroupAnagrams2(string[] strs) {
            string[][] sortedStrs = new string[strs.Length][];
            for(int i = 0; i<sortedStrs.Length; i++){
                sortedStrs[i] = new string[2];
                sortedStrs[i][0] = sort(strs[i]);
                sortedStrs[i][1] = strs[i];
            }
            Array.Sort(sortedStrs,(a,b)=>{ return a[0].CompareTo(b[0]); });
            IList<IList<string>> res = new List<IList<string>>();
            IList<string> row = new List<string>();
            row.Add(sortedStrs[0][1]);

            for(int i = 1; i<sortedStrs.Length; i++){
                if(sortedStrs[i-1][0]!=sortedStrs[i][0]){
                    res.Add(row);
                    row = new List<string>();
                }
                row.Add(sortedStrs[i][1]);
            }            
            res.Add(row);
            return res;    
        }

        private string sort(string s){
            char[] arC = s.ToCharArray();
            Array.Sort(arC);
            return new string(arC);
        }
    }
}