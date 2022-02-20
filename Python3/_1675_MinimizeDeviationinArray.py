import sys
from typing import List
import heapq
class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        heap = []
        mi = sys.maxsize
        ma = 0
        res = sys.maxsize
        for n in nums:
            if n%2 == 1:
                n *= 2
            mi = min(mi,n)
            heapq.heappush(heap,-n)
        while True:
            ma = -heapq.heappop(heap)
            res = min(res,ma-mi)
            if ma%2 == 1:
                return int(res)
            ma /= 2
            mi = min(mi, ma)
            heapq.heappush(heap,-ma)

test = Solution()
print(test.minimumDeviation([1,2,3,4]))