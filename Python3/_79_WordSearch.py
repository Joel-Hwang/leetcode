from operator import truediv
from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[i])):
                if word[0] is board[i][j]:
                    pSet = set()
                    pSet.add(str(i)+"-"+str(j))
                    res = self.rec(board,word[1:],pSet,i,j)
                    if res:
                        return True

        return False
    
    def rec(self, board: List[List[str]], word:str, pSet: set, i:int, j:int) -> bool:
        if len(word) is 0:
                return True

        if i-1>=0 and word[0] is board[i-1][j]:
            key = str(i-1) +"-"+str(j)
            if key not in pSet:
                pSet.add( key )
                if self.rec(board,word[1:],pSet,i-1,j):
                    return True
                pSet.remove(key)
        
        if i+1<len(board) and word[0] is board[i+1][j]:
            key = str(i+1) +"-"+str(j)
            if key not in pSet:
                pSet.add( key )
                if self.rec(board,word[1:],pSet,i+1,j):
                    return True
                pSet.remove(key)
        
        if j-1>=0 and word[0] is board[i][j-1]:
            key = str(i) +"-"+str(j-1)
            if key not in pSet:
                pSet.add( key )
                if self.rec(board,word[1:],pSet,i,j-1):
                    return True
                pSet.remove(key)
        
        if j+1<len(board[0]) and word[0] is board[i][j+1]:
            key = str(i) +"-"+str(j+1)
            if key not in pSet:
                pSet.add( key )
                if self.rec(board,word[1:],pSet,i,j+1):
                    return True
                pSet.remove(key)
       
        return False


test = Solution()

print(test.exist(board = [["A","B","C","E"],
                          ["S","F","E","S"],
                          ["A","D","E","E"]], word = "ABCESEEEFS"))   
                           
print(test.exist(board = [["A"],
                          ["A"]], word = "AAA"))    


print(test.exist(board = [["A","B","C","E"],
                          ["S","F","C","S"],
                          ["A","D","E","E"]], word = "SEE"))  

print(test.exist(board = [["A","B","C","E"],
                          ["S","F","C","S"],
                          ["A","D","E","E"]], word = "ABCCED"))    

    