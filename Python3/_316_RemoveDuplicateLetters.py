class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        lastIndex = {}
        seen = {}
        for i in range(len(s)):
            lastIndex[s[i]] = i
        
        stk = []
        for i in range(len(s)):
            if s[i] in seen and seen[s[i]] is True:
                continue
            while len(stk) >0 and stk[-1] > s[i] and lastIndex[stk[-1]] > i:
                seen[stk.pop()] = False
            stk.append(s[i])
            seen[s[i]] = True

        res = ""
        while len(stk) > 0:
            res = stk.pop() + res
        return res

test = Solution()
print(test.removeDuplicateLetters("cbacdcbc"))
print(test.removeDuplicateLetters("bcabc"))