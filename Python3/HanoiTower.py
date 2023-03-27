class Solution:
    def move(self, n: int,originColumn: int, targetColumn: int) -> None:
        if n == 0:
            return
        list = ['A','B','C']
        cnt = len(list)
        #1,2번 0이고.. 0,2번 1이고..  0,1번이면 2
        empty = 3 - (originColumn + targetColumn)
        
        self.move(n-1,originColumn, empty  )
        print(  str(n) +" 원반을 " + list[targetColumn] + " 기둥으로 이동")
        self.move(n-1,empty, targetColumn)
        return None
test = Solution()
#0:A, 1:B, 2:C
test.move(5,0,1)