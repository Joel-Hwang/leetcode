class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if s == "" :
            return True
        csS = 0
        for c in t:
            if c is s[csS]:
                csS+=1
            if csS >= len(s):
                return True
        return False

test = Solution()
print(test.isSubsequence("abc","adddbdsdcdd"))