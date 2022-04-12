# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.ar = []
        self.idx = 0
        self.preOrder(root)

    def preOrder(self,node:TreeNode):
        if node is None:
            return
        self.preOrder(node.left)
        self.ar.append(node.val)
        self.preOrder(node.right)

    def next(self) -> int:
        res = self.ar[self.idx]
        self.idx+=1
        return res

    def hasNext(self) -> bool:
        return self.idx < len(self.ar)
        


# Your BSTIterator object will be instantiated and called as such:
root = TreeNode(1)
obj = BSTIterator(root)
param_1 = obj.next()
print(param_1)
param_2 = obj.hasNext()
print(param_2)


root = TreeNode(5)
obj = BSTIterator(root)
param_1 = obj.next()
print(param_1)
param_2 = obj.hasNext()
print(param_2)