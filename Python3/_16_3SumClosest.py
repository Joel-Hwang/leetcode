from typing import List
import math
from MinSort import sort


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        res = nums[0]+nums[1]+nums[2]
        for i in range(0,n-2):
            l = i+1
            r = n-1
            while l<r:
                temp = nums[i] + nums[l] + nums[r]
                if temp > target:
                    r-=1
                else:
                    l+=1
                if abs(res - target) > abs(temp - target):
                        res = temp
        return res


test = Solution()
print(test.threeSumClosest([1,1,-1,1],-100))