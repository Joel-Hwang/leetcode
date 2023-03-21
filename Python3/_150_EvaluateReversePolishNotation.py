from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stk = []
        for i in range(len(tokens)):
            if len(tokens[i]) == 1 and tokens[i] in '+-*/':
                stk.append(self.calcuate(tokens[i],stk.pop(), stk.pop()))
            else:
                stk.append(int(tokens[i]))
        return stk[0]    

    def calcuate(self, operator:str, op2:int, op1:int) -> int:
        if operator is '+':
            return op1 + op2
        if operator is '-': 
            return op1 - op2
        if operator is '*': 
            return op1 * op2
        if operator is '/': 
            return int(op1/op2)
        return 0

test = Solution()
print(test.evalRPN(["18"]))