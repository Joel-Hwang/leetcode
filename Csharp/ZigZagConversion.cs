using System;
using System.Collections;

namespace Csharp
{
    public class ZigZagConversion
    {
        public string Convert(string s, int numRows)
        {
            if(numRows == 1) return s;

            ArrayList rows = new ArrayList();
            for(int i = 0; i<Math.Min(numRows, s.Length); i++){
                rows.Add("");
            }

            int curRow = 0;
            bool goingDown = false;

            foreach(char c in s.ToCharArray()){
                rows[curRow] += c.ToString();
                if(curRow == 0 || curRow == numRows -1) goingDown = !goingDown;
                curRow += goingDown?1:-1;
            }

            string result = "";
            foreach(string row in rows){
                result += row;
            }
            return result;
        }
    }



}