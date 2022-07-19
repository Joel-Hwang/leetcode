from typing import List


class Solution:
    def minSpaceWastedKResizing(self, nums: List[int], k: int) -> int:
        memory = [ [-1] * 200 for i in range(200) ]
        return self.dp(nums,memory,0,k)

    def dp(self, nums: List[int], memory: List[int], i: int, k: int)-> int:
        if i == len(nums):
            return 0
        if k < 0 :
            return 200000000
        if memory[i][k] >= 0:
            return memory[i][k]
        
        sum = 0
        maxVal = nums[i]
        ans = 200000000
        for j in range(i,len(nums)):
            sum += nums[j]
            maxVal = max(maxVal,nums[j])
            waste = maxVal*(j-i+1) - sum
            ans = min(ans,self.dp(nums,memory,j+1,k-1)+waste)
        memory[i][k] = ans
        return ans