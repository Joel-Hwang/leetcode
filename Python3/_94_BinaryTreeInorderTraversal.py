# Definition for a binary tree node.
from operator import eq
from typing import List
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right
class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        self.rec(root,res)
        return res

    def rec(self, node:TreeNode,res:List):
        if node == None: 
            return
        self.rec(node.left,res)
        res.append(node.val)
        self.rec(node.right,res)