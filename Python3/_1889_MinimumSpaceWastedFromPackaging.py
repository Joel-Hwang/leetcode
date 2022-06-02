from typing import List

class Solution:
    def minWastedSpace(self, packages: List[int], boxes: List[List[int]]) -> int:
        res = 100000000000
        packages.sort()
        sumP = 0
        for p in packages:
            sumP += p
        
        for box in boxes:
            box.sort()
            if box[-1] < packages[-1]: 
                continue
            i = 0
            j = 0
            cur = 0
            for b in box:
                j = self.findIndex(packages,b+1)
                cur += b*(j-i)
                i = j
            res = min(res,cur)

        if res == 100000000000:
            return -1
        else:
            return (res-sumP)%100000007

    def findIndex(self, packages, b) -> int:
        l = 0
        r = len(packages)
        while l<r:
            mid = (int)((l+r)/2)
            if packages[mid] < b:
                l = mid+1
            else:
                r = mid
        return l
        
test = Solution()
test.minWastedSpace([2,3,5], [[4,8],[2,8]])