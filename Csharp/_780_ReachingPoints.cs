using System;
using System.Collections.Generic;

namespace Csharp
{
    public class _780_ReachingPoints
    {
        public bool ReachingPoints(int sx, int sy, int tx, int ty) {
            while(sx<tx && sy<ty){
                if(tx < ty)
                    ty %= tx;
                else tx %= ty;
            }

            return tx == sx && sy<=ty && (ty-sy)%sx == 0 ||
                ty == sy && tx>=sx && (tx-sx)%sy == 0;
        }
    }
}