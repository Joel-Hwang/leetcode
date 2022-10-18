# Definition for a binary tree node.
from tkinter.messagebox import NO
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        if root == None:
            return 0

        return  self.rec(root,targetSum) + self.pathSum(root.left,targetSum) + self.pathSum(root.right,targetSum)  
    
    def rec(self, node: Optional[TreeNode], targetSum: int) -> int:
        if node == None:
            return 0
        
        isTargetSum = 0
        if targetSum == node.val:
            isTargetSum = 1
        else:
            isTargetSum = 0
        return isTargetSum + self.rec(node.left,targetSum-node.val) + self.rec(node.right,targetSum-node.val)
        