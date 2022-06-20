class Solution:
    def validPalindrome(self, s: str) -> bool:
        isPal = self.isPalindrome(s)
        if isPal:
            return True

        for i in range((int)(len(s)/2)):
            if s[i] != s[-i-1]:
                left = s[0:i]+s[i+1:]
                right = s[0:-i-1]+s[-i:]
                if i == 0:
                    right = s[0:-i-1]
                return self.isPalindrome(left) or self.isPalindrome(right)
        
    
    def isPalindrome(self, s: str) -> bool:
        for i in range((int)(len(s)/2)):
            if s[i] != s[-i-1]:
                return False
        return True

test = Solution()

print(test.validPalindrome("eccer"))
print(test.validPalindrome("abca"))
print(test.validPalindrome("abc"))
print(test.validPalindrome("abcddcba"))
