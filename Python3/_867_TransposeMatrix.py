

from typing import List

class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        result = [[0]*len(matrix) for _ in range(len(matrix[0]))]
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                result[j][i] = matrix[i][j]
        return result  

test = Solution()
test.transpose([[2,4,-1],[-10,5,11],[18,-7,6]])
