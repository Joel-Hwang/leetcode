class Solution:
    def countSubstrings(self, s: str) -> int:
        if len(s) == 0:
            return 0
        count = 1    
        for i in range(1, len(s)):
            count += self.rec(s,i,i)
            count += self.rec(s,i-1,i)
        return count
    
    def rec(self,s,l,r) -> int:
        res = 0
        while l>=0 and r < len(s) and s[l] == s[r]:
            res += 1
            l -= 1
            r += 1
        return res


test = Solution()
print(test.countSubstrings("aaa"))

    