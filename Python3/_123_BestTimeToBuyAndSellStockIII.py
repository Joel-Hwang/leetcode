

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        oneBuy = 100000
        twoBuy = 100000
        oneSell = 0
        twoSell = 0
        for p in prices:
            oneBuy = min(oneBuy,p)
            oneSell = max(oneSell,p-oneBuy)
            twoBuy = min(twoBuy,p-oneSell)
            twoSell = max(twoSell,p-twoBuy)
        return twoSell