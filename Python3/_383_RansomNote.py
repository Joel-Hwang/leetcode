class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        dic = {}
        for m in magazine:
            if m in dic.keys():
                dic[m] += 1
            else:
                dic[m] = 1
        for r in ransomNote:
            if r in dic.keys():
                dic[r] -= 1
            else:
                return False

        for key in dic.keys():
            if dic[key] < 0:
                return False
        return True
test = Solution()
test.canConstruct("ab","ab")
