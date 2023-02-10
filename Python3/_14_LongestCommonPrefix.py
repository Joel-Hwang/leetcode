from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        tong = ""
        for i in range(len(strs[0])):
            for tempStr in strs:
                if len(tempStr) == i or tempStr[i] != strs[0][i]:
                    return tong
            tong+=(strs[0][i])
        return tong

    def longestCommonPrefix2(self, strs: List[str]) -> str:
        for i in range(len(strs[0])):
            for tempStr in strs:
                if len(tempStr) == i or tempStr[i] != strs[0][i]:
                    return strs[0][:i]
        return strs[0]

test = Solution()
print( test.longestCommonPrefix(["","coff","coffe"]) )
print( test.longestCommonPrefix(["coffee","coff","coffe"]) )
print( test.longestCommonPrefix(["coffee","cof","cap"]) )
