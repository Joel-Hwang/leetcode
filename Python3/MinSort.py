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

def find_min(s1, s2):
    if s1 < s2:
        return s1
    return s2

def find_max(s1, s2):
    if s1 > s2:
        return s1
    return s2

def sort(words):
    sorted = []
    cnt = len(words) # list size (cnt stands for count)
    j = 0
    while j < cnt:
        for i in range(0, len(words)):
            min = find_min(words[0], words[i])
        words.remove(min)
        sorted.append(min)
        j +=1
    return sorted


def shift(lst,k):   
    i = lst[0:k]    #store list slice to move
    j = lst[k:]     #store rest of list in slice
    lst_new = j + i #attach moved slice to end of rest slice
    return lst_new

def rotated(lst, n):
    if len(lst) > 0:    
        num = n % len(lst)
        lst_new = shift(lst, num)
    else:
        lst_new = lst
    return lst_new

words = ['e' , 'd' , 'c' , 'b' , 'a' ]
print(sort(words))