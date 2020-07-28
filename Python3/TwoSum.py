from typing import List

class Twosum:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for i,v in enumerate(nums):
            n = target-v
            if n in hm:
                return [i,hm[n]]
            else:
                hm[v] = i
        return []
       
            
test = Twosum()
test.twoSum([2,7,11,15],9)   