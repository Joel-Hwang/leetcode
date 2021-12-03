from typing import List

class MinSort:
    def getMin(self, i:int, j:int, lst: List[int] ) -> int:
        if(lst[i] < lst[j]):
            return i
        return j

    def swap(self, i:int, j:int, lst: List[int]):
        temp = lst[i]
        lst[i] = lst[j]
        lst[j] = temp

    def sort(self, lst: List[int]):
        for i in range(0, len(lst)-1):
            minIdx = i
            for j in range(i+1, len(lst)):
                minIdx = self.getMin(minIdx,j,lst)
            self.swap(i,minIdx,lst)

test = MinSort()
lst = [1,3,7,4,2]
test.sort(lst)
print(lst) 