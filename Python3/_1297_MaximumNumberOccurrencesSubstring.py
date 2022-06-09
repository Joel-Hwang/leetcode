

class Solution:
    def maxFreq(self, s: str, maxLetters: int, minSize: int, maxSize: int) -> int:
        dic = {}
        res = 0
        for i in range(len(s)):
            cur = s[i:i+minSize]
            if(len(cur) < minSize):
                continue
            if self.isValid(cur,maxLetters):
                if cur in dic:
                    dic[cur] += 1
                    
                else:
                    dic[cur] = 1
                res = max(res,dic[cur])
        return res

    def isValid(self, s:str, maxLetters:int) -> bool:
        alph = {}
        for c in s:
            if c in alph:
                alph[c] = alph[c]+1
            else:
                alph[c] = 1
        return len(alph) <= maxLetters


test = Solution()
test.maxFreq("abcde",2,3,3)