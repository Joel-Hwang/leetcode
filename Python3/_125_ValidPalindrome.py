class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        l = 0
        r = len(s)-1
        while l<=r:
            if ('a'<=s[l]<='z') == False and ('0'<=s[l]<='9') == False:
                l+=1
                continue
            if ('a'<=s[r]<='z') == False and ('0'<=s[r]<='9') == False:
                r-=1
                continue
            if s[l] != s[r]:
                return False
            else:
                l+=1
                r-=1
        return True
    
test = Solution()
print(test.isPalindrome("0P"))
print(test.isPalindrome("A man, a plan, a canal: Panama"))
print(test.isPalindrome("Arace a car"))