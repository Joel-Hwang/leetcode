from typing import List
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i,v in enumerate(nums):
            if v <= 0 or v > n:
                nums[i] = n+1

        for i,v in enumerate(nums):
            v = abs(v)
            if v > n or  nums[v-1] < 0:
                continue

            nums[v-1] = -nums[v-1] 

        for i,v in enumerate(nums):
            if v > 0:
                return i+1
        return n+1 

test = Solution()
print(test.firstMissingPositive([1,1]))
print(test.firstMissingPositive([1,2,3,4,5]))
print(test.firstMissingPositive([1,2,3,6,5]))

