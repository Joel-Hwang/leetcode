using System;
using System.Collections.Generic;

namespace Csharp
{
    public class _1996_TheNumberOfWeakCharactersIntheGame {
        public int NumberOfWeakCharacters(int[][] properties) {
            Array.Sort(properties, (int[] a, int[] b) => {
                if(a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });

            int res = 0;
            int max = properties[properties.Length-1][1];
            for(int i = properties.Length - 2; i >= 0; i--){
                if(max > properties[i][1]) res++;
                else max = properties[i][1];
            }

            return res;
        }
    }
}