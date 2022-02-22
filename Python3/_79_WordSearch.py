from operator import truediv
from typing import List
import time

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.times = 0
        for i in range(len(board)):
            for j in range(len(board[i])):
                if word[0] == board[i][j]:
                    pSet = set()
                    pSet.add(str(i)+"-"+str(j))
                    res = self.rec(board,word[1:],pSet,i,j)
                    if res:
                        print(self.times)
                        return True
        return False
    
    def rec(self, board: List[List[str]], word:str, pSet: set, i:int, j:int) -> bool:
        if len(word) == 0:
                return True

        arrows = [[i-1,j],[i+1,j],[i,j-1],[i,j+1]]
        for arrow in arrows:
            if 0 <= arrow[0] < len(board) and 0<=arrow[1] < len(board[0]) and word[0] == board[arrow[0]][arrow[1]]:
                key = str(arrow[0]) +"-"+str(arrow[1])
                if key not in pSet:
                    pSet.add( key )
                    if self.rec(board,word[1:],pSet,arrow[0],arrow[1]):
                        return True
                    pSet.remove(key)

        #if i-1>=0 and word[0] is board[i-1][j]:
        #    key = str(i-1) +"-"+str(j)
        #    if key not in pSet:
        #        pSet.add( key )
        #        if self.rec(board,word[1:],pSet,i-1,j):
        #            return True
        #        pSet.remove(key)
        #
        #if i+1<len(board) and word[0] is board[i+1][j]:
        #    key = str(i+1) +"-"+str(j)
        #    if key not in pSet:
        #        pSet.add( key )
        #        if self.rec(board,word[1:],pSet,i+1,j):
        #            return True
        #        pSet.remove(key)
        #
        #if j-1>=0 and word[0] is board[i][j-1]:
        #    key = str(i) +"-"+str(j-1)
        #    if key not in pSet:
        #        pSet.add( key )
        #        if self.rec(board,word[1:],pSet,i,j-1):
        #            return True
        #        pSet.remove(key)
        #
        #if j+1<len(board[0]) and word[0] is board[i][j+1]:
        #   key = str(i) +"-"+str(j+1)
        #   if key not in pSet:
        #       pSet.add( key )
        #       if self.rec(board,word[1:],pSet,i,j+1):
        #           return True
        #       pSet.remove(key)
       
        return False

start = time.time()
test = Solution()




print(test.exist(board = [["A","A","A","A","A","A"],
                          ["A","A","A","A","A","A"],
                          ["A","A","A","A","A","A"],
                          ["A","A","A","A","A","A"],
                          ["A","A","A","A","A","A"],
                          ["A","A","A","A","A","A"]], word = "AAAAAAAAAAAABAA"))  

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
print("time :", time.time() - start)
    