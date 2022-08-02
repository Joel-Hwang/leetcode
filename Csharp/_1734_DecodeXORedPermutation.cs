using System;
using System.Collections.Generic;

namespace Csharp
{

    public class _1734_DecodeXORedPermutation {
        public int[] Decode(int[] encoded) {
            int[] res = new int[encoded.Length + 1];
            for(int i = 1; i<encoded.Length; i+=2)
            {
                res[0] ^= i;
                res[0] ^= i+1;
                res[0] ^= encoded[i];
            }
            res[0] ^= encoded.Length+1;
            for(int i = 0; i<encoded.Length; i++)
            {
                res[i+1] = res[i]^encoded[i];
            }

            return res;
        }
    }
}