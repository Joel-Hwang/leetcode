from ast import Set
from pydoc import visiblename
from typing import List


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        visited = {"0000"}
        deadendSet = self.getDeadendsSet(deadends)
        q = ["0000"]
        res = 0
        while len(q) > 0:
            n = len(q)
            for i in range(n):
                cur = q.pop(0)
                if target == cur:
                    return res
                if cur in deadendSet:
                    continue
                self.addQueue(q,visited,cur)

            res +=1
        return -1

    def getDeadendsSet(self, deadends: List[str]) -> set:
        res = set()
        for deadend in deadends:
            res.add(deadend)
        return res
    def addQueue(self, q: List[str], visited: set[str], node:str) -> None:
        children = self.getChildren(node)
        for child in children:
            if child in visited:
                continue
            q.append(child)
            visited.add(child)

    def getChildren(self, node :str) -> List[str]:
        res = []
        a = int(node[0])
        b = int(node[1])
        c = int(node[2])
        d = int(node[3])
        
        res.append( str((a+11)%10) + str(b) + str(c) + str(d)  )
        res.append( str((a+9)%10) + str(b) + str(c) + str(d)  )
        res.append( str(a) + str((b+11)%10) + str(c) + str(d)  )
        res.append( str(a) + str((b+9)%10)  + str(c) + str(d)  )
        res.append( str(a) + str(b) + str((c+11)%10) + str(d)  )
        res.append( str(a) + str(b) + str((c+9)%10) + str(d)  )
        res.append( str(a) + str(b) + str(c) + str((d+11)%10) )
        res.append( str(a) + str(b) + str(c) + str((d+9)%10)  )
        
        return res
    
test = Solution()
print( test.openLock(["0201","0101","0102","1212","2002"],"0202") )