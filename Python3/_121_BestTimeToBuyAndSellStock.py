

from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left,right=0,1
        maxProfit = 0
        while right<len(prices):
            
            maxProfit = max(maxProfit, prices[right]-prices[left])
            if prices[left] < prices[right]:
                prices[right] = prices[left]
            left+=1
            right+=1
        return maxProfit


test = Solution()
test.maxProfit([7,1,5,3,6,4])