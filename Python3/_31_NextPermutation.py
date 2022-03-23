from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        idxSwap = len(nums)-2
        while idxSwap>=0 and nums[idxSwap+1] <= nums[idxSwap] :
            idxSwap-=1
        
        if idxSwap < 0 :
            self.reverse(nums, 0, len(nums))
            return None

        j = len(nums)-1
        while nums[idxSwap] >= nums[j]:
             j-=1
        temp = nums[idxSwap]
        nums[idxSwap] = nums[j]
        nums[j] = temp
        self.reverse(nums,idxSwap+1, len(nums))
    
    def reverse(self, nums:List[int], start:int, end:int) -> None:
        for i in range(start,(int)(start+(end-start)/2)):
            temp = nums[i]
            nums[i] = nums[start + end-i-1]
            nums[start + end-i-1] = temp
