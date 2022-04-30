from typing import List
from heapq import heappush, heappop

class Solution:
    def kthSmallestPrimeFraction(self, arr: List[int], k: int) -> List[int]:
        n = len(arr)
        
        heap = []
        n = len(arr)
        for i in range(n-1):
            heappush(heap,(arr[i]/arr[n-1],i,n-1))

        while k > 1 and len(heap) > 0:
            k -= 1
            cur = heappop(heap)
            if cur[2] -1 > cur[1]:
                heappush(heap,(arr[cur[1]]/arr[cur[2]-1],cur[1],cur[2]-1))
            
        last = heappop(heap)

        return [arr[last[1]],arr[last[2]]]

test = Solution()
print(test.kthSmallestPrimeFraction([1,2,3,5],3))