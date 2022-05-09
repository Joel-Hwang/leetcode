from typing import List


class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        third = -1000000000
        stack = []
        for i in range(len(nums)-1,-1,-1):
            if nums[i] < third:
                return True

            while len(stack) > 0 and nums[i] >stack[-1]:
                third = stack.pop()

            stack.append(nums[i])

        return False