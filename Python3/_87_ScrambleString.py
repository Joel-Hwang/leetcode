class Solution:
    myMap = {}
    def isScramble(self, s1: str, s2: str) -> bool:
        if(s1 is s2):
            return True

        key = s1+s2
        if key in self.myMap:
            return self.myMap[key]
        n = len(s1)
        flag = False
        for i in range(1,n):
            s1P1 = s1[:i]
            s1P2 = s1[i:]
            swap = self.isScramble(s1P1,s2[n-i:n]) and self.isScramble(s1P2,s2[:n-i])
            unswap = self.isScramble(s1P1,s2[:i]) and self.isScramble(s1P2,s2[i:])
            if swap or unswap:
                flag = True
            self.myMap[key] = flag    
        return flag

test = Solution()
print(test.isScramble("abc","cba"))