import math
from typing import List


class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        res = 0
        l = 0
        r = len(tokens)-1
        points = 0

        while l <= r :
            if power >= tokens[l]:
                power -= tokens[l]
                points += 1
                res = max(res,points)
                l+=1
            elif points > 0:
                power += tokens[r]
                r-=1
                points -=1
            else:
                break



        return res