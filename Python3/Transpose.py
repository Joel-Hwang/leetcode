from typing import List

class Transpose:
    def transpose2(self, nums: List[List[int]]) -> List[List[int]]:
        res = [[0]*len(nums) for i in range(len(nums[0])) ]
        for i,row in enumerate(nums):
            for j,col in enumerate(row):
                res[j][i] = col
        return res  
    

        
       
def transpose2(nums):
    res = [[0]*len(nums) for i in range(len(nums[0])) ]
    for i,row in enumerate(nums):
        for j,col in enumerate(row):
            res[j][i] = col
    return res

def transpose(matrix):
    trans_matrix = []
    for i in range(len(matrix[0])):
        trans_row = []
        for j in range(len(matrix)):
            trans_row.append(matrix[j][i])
        trans_matrix.append(trans_row)
    return trans_matrix

test = Transpose()
result = transpose([[6,7,2,3,1],[9,9,7,4,5]])
print(result) 


