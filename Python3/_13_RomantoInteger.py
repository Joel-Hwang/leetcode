class Solution:
    def romanToInt(self, s: str) -> int:
        map = { 'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90,'CD': 400,'CM':900,
                'I': 1 , 'V': 5,'X': 10,'L': 50,'C': 100, 'D':500, 'M':1000 }
                
        res = 0
        for i in s:
            res += map[i]
        
        if 'IV' in s or 'IX' in s:
            res -= 2
        if 'XL' in s or 'XC' in s:
            res -= 20
        if 'CD' in s or 'CM' in s:
            res -= 200

        return res


test = Solution()
print(test.romanToInt("MCMXCIV"))