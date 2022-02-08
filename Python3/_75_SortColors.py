from typing import List
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        cnt = [0,0,0]
        for n in nums:
            cnt[n]+=1
        
        idx = 0
        for i in range(len(cnt)):
            for j in range(cnt[i]):
                nums[idx] = i
                idx+=1

test = Solution()
rgb = [2,0,2,1,1,0]
test.sortColors(rgb)
print(test)


     