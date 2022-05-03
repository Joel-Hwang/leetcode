from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = 0
        col = len(matrix[0])-1
        while row < len(matrix) and col >=0:
            if matrix[row][col] == target:
                return True
            if matrix[row][col] < target:
                row +=1
            else:
                col -= 1
        return False


test = Solution()

print(test.searchMatrix([[1,2,3],[4,5,6],[7,8,9]],10))