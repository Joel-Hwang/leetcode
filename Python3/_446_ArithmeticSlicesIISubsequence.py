from typing import List


class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        maps = []
        ans = 0
        for i in nums:
            maps.append({})
        for i in range(len(nums)):
            for j in range(i):
                cd = nums[i] - nums[j]
                countJ = 0
                countI = 0
                if cd in maps[j]:
                    countJ = maps[j][cd]
                if cd in maps[i]:
                    countI = maps[i][cd]
                maps[i][cd] = countJ + countI + 1
                ans += countJ

        return ans

test = Solution()
print(test.numberOfArithmeticSlices([2,4,6,8,10]))