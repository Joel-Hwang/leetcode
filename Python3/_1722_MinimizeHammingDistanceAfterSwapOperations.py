

from typing import List


class Solution:
    def minimumHammingDistance(self, source: List[int], target: List[int], allowedSwaps: List[List[int]]) -> int:
        union = [i for i in range(len(source))]

        for swap in allowedSwaps:
            parentA = self.find(union, swap[0])
            parentB = self.find(union, swap[1])
            if parentA != parentB:
                union[parentA] = parentB
        
        map = {}
        for i,v in enumerate(source):
            root = self.find(union, i)
            if root not in map:
                map[root] = {}

            if v not in map[root]:
               map[root][v] = 1
            else:
                map[root][v] += 1

        res = 0
        for i,v in enumerate(target):
            root = self.find(union, i)
            if v not in map[root] or map[root][v] == 0:
                res += 1
            else:
                map[root][v] -= 1

        return res


    def find(self, union: List[int], idx : int) -> int:
        if union[idx] == idx:
            return idx
        else:
            return self.find(union,union[idx])