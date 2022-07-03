from typing import List
import copy

class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        res = []
        orderedNums = copy.deepcopy(nums)
        orderedNums.sort()
        map = {}
        for (i,v) in enumerate(orderedNums):
            if v not in map:
                map[v] = i

        for num in nums:
            res.append(map[num])
        return res

test = Solution()
print( test.smallerNumbersThanCurrent([8,1,2,2,3]) )