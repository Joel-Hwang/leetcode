from typing import List


class Solution:
    
    def swimInWater(self, grid: List[List[int]]) -> int:
        self.n:int = len(grid)
        l:int = grid[0][0]
        r:int = self.n*self.n - 1
        while(l < r):
            m:int = int((l+r)/2)
            flags = [[False]*self.n for i in range(self.n)]
            if(self.dfs(grid,0,0,m,flags)):
                r = m
            else:
                l = m+1

        return l

    def dfs(self, grid:List[List[int]], i:int, j:int, m:int, flags:List[List[bool]]):
        if i<0 or i>=self.n or j<0 or j>=self.n or flags[i][j]:
            return 
        flags[i][j] = True
        if grid[i][j] > m:
            return False
        if i == self.n-1 and j == self.n-1:
            return True
        
        return self.dfs(grid,i+1,j,m,flags) or self.dfs(grid,i-1,j,m,flags) or self.dfs(grid,i,j+1,m,flags) or self.dfs(grid,i,j-1,m,flags)


test = Solution()

test.swimInWater([[0,2],[1,3]])