from tkinter.messagebox import NO
from typing import List
import copy

class Solution:
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        resSet = set()
        for i in range(len(candidates)):
            if i>0 and candidates[i] == candidates[i-1]:
                continue
            self.rec(candidates, [candidates[i]] ,candidates[i],target, res, resSet)
        return res

    def rec(self, candidates: List[int], p:List[int], sump: int, target: int, res: List[List[int]], resSet:set ):
        if sump == target:
            newp = copy.deepcopy(p)
            newp.sort()
            key = ' '.join( [str(int) for int in newp] )
            if key not in resSet:
                res.append(newp)
                resSet.add(key)
            
            return
        if sump > target:
            return
        
        for i in range(len(candidates)):
            if i>0 and candidates[i] == candidates[i-1]:
                continue
            p.append(candidates[i])
            self.rec(candidates,p ,sump+candidates[i],target, res, resSet)
            del p[-1]

    

test = Solution()
res = test.combinationSum([2,3,5],8)
print(res)