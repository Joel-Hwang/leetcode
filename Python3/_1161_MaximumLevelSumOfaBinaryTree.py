from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        q = []
        maxLevel:int = 0
        curLevel:int = 0
        maxSum:int = -1000000
        q.append(root)
        while len(q)!= 0:
            curLevel+=1
            curSum = 0
            size = len(q)
            for i in range(size):
                curNode:TreeNode = q.pop(0)
                curSum += curNode.val
                if curNode.left is not None:
                    q.append(curNode.left)
                if curNode.right is not None:
                    q.append(curNode.right)
            if curSum > maxSum:
                maxSum = curSum
                maxLevel = curLevel

        return maxLevel