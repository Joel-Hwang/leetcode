from typing import List

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nonZeroIdx = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                temp = nums[i]
                nums[i] = nums[nonZeroIdx]
                nums[nonZeroIdx] = temp
                nonZeroIdx += 1

test = Solution()

ar = [0,1,0,3,12]
test.moveZeroes(ar)    