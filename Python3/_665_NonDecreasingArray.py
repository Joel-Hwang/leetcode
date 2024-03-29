from typing import List


class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        cnt = 0
        for i in range(1,len(nums)):
            if nums[i] < nums[i-1]:
                cnt+=1
                if i-2 < 0 or nums[i-2] <= nums[i]:
                    nums[i-1] = nums[i]
                else:
                    nums[i] = nums[i-1]

        return cnt<=1


test = Solution()
test.checkPossibility([3,4,2,3])
test.checkPossibility([4,2,3])
test.checkPossibility([-1,4,2,3])