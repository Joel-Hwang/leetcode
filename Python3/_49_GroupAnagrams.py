from typing import List
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        map = {}
        for str in strs:
            key = self.sortedStr(str)
            if key in map:
                map[key].append(str)
            else:
                map[key] = [str]
        
        res = []
        for key in map:
            row = map[key]
            res.append(row)
        return res
    
    def sortedStr(self, str:str) -> str:
        arStr = list(str)
        arStr.sort()
        return ''.join(arStr)

test = Solution()
strs = ["eat","tea","tan","ate","nat","bat"]
#strs = [""]
print( test.groupAnagrams(strs) )
