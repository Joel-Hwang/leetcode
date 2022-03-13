from cgitb import reset


class Solution:
    def calculate(self, s: str) -> int:
        res = 0
        num = 0
        sign = 1
        stack = []
        for c in s:
            if '0'<=c and c<='9':
                num = num*10+ int(c)
            elif c == '+':
                res += sign*num
                sign = 1
                num = 0
            elif c == '-':
                res += sign*num
                sign = -1
                num = 0
            elif c == '(':
                stack.append(res)
                stack.append(sign)
                num = 0
                res = 0
                sign = 1
            elif c == ')':
                res += sign*num
                res *= stack.pop()
                res += stack.pop()
                num = 0
        if num != 0:
            res += sign*num
        return res

test = Solution()
print(test.calculate("3-(2+3)"))

