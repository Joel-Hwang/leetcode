from typing import List


class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        res = 0
        properties.sort(key=lambda x:(x[0],-x[1]))

        max = properties[len(properties)-1][1]
        for i in range(len(properties)-2,-1,-1):
            if properties[i][1] < max:
                res +=1
            else:
                max = properties[i][1]
        return res