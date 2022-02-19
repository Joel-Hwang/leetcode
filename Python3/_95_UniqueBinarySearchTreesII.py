from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        
        return self.helper(1,n)

    def helper(self, low:int, high:int) -> List[TreeNode]:
        res = []
        if low > high:
            res.append(None)
            return res

        for i in range(low, high+1):
            left = self.helper(low, i-1)
            right = self.helper(i+1, high)

            for l in left:
                for r in right:
                    res.append(TreeNode(i,l,r))
        return res

test = Solution()
test.generateTrees(3)