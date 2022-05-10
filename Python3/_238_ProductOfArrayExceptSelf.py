from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        allProdct = 1
        zeroCnt = 0
        for n in nums:
            if n == 0: 
                zeroCnt+=1
            else:
                allProdct *= n

        result = []
        for n in nums:
            if zeroCnt > 1:
                result.append(0)
                continue
            
            if zeroCnt == 1:
                if n == 0:
                    result.append(allProdct)
                else:
                    result.append(0)

            else:
                result.append((int)(allProdct/n))
        return result

test = Solution()
print(test.productExceptSelf([1,2,3,4]))