from typing import List
class Solution:
    def maxArea(self, height: List[int]) -> int:
        l=0
        r=len(height)-1
        res= 0#min(height[l],height[r])*(len(height)-1)
        while(l<r):
            res = max(res,min(height[l],height[r])*(r-l))
            
            if height[l] < height[r]: #r이 아무리 커져도 결국 l이 작기 때문에 maxArea는 오히려 줄어듬. 그래서 l을 변경
                l+=1
            else:
                r-=1
        return res

test = Solution()
print(test.maxArea([1,8,6,2,5,4,8,3,7]))

