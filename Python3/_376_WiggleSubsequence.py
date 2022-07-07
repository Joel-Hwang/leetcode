from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return len(nums)

        preDiff = nums[1] - nums[0]
        res = 0
        if preDiff == 0:
            res = 1
        else:
            res = 2 

        for i in range(2,len(nums)):
            diff = nums[i] - nums[i-1]
            if (diff > 0 and preDiff <=0) or (diff < 0 and preDiff >=0 ):
                res +=1  
                preDiff = diff    

        return res
        