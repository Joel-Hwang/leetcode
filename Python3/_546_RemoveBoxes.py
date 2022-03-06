from typing import List


class Solution:
    def __init__(self) -> None:
        self.memo = []

    def removeBoxes(self, boxes: List[int]) -> int:
        n = len(boxes)
        for i in range(n):
            ar2 = []
            for j in range(n):
                ar3 = []
                for k in range(n):
                    ar3.append(0)
                ar2.append(ar3)
            self.memo.append(ar2)

        return self.dp(boxes,0,n-1,0)
    def dp(self, boxes: List[int], l:int, r:int, k:int)-> int:
        if l > r:
            return 0
        if self.memo[l][r][k] > 0:
            return self.memo[l][r][k]
        oriL = l
        oriK = k
        while l+1<=r and boxes[l] == boxes[l+1]:
            l += 1
            k += 1
        ans = (k+1)*(k+1) + self.dp(boxes,l+1,r,0)
        for j in range(l+1,r+1):
            if boxes[j] == boxes[l]:
                ans = max(ans,self.dp(boxes,j,r,k+1) + self.dp(boxes,l+1,j-1,0))
        self.memo[oriL][r][oriK] = ans
        return ans