import math
class LongestSubstr:
    def lengthOfLongestSubstring(self, s: str) -> int:
        i=0
        j=0
        ans=0
        n=len(s)
        mySet = set([])
        while i<n and j<n:
            if s[j] not in mySet:
                mySet.add(s[j])
                j+=1
                ans = max(ans, j-i)
            else:
                mySet.remove(s[i])
                i+=1
        return ans



test = LongestSubstr()
   
print(test.lengthOfLongestSubstring("abcabcbb"))