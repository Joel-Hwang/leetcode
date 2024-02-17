from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        pancestor = []
        self.dfs2(root,p,pancestor)
        qancestor = []
        self.dfs2(root,q,qancestor)
        for i in pancestor:
            for j in qancestor:
                if i== j:
                    return i
        return None
    

    def dfs2(self, node, target, ancestor )-> bool:
        if node is None:
            return False
        if node == target:
            ancestor.insert(0,node)
            return True
        
        ancestor.insert(0,node)
        left = self.dfs2(node.left,target,ancestor)
        if left is True:
            return True
        del ancestor[0]

        ancestor.insert(0,node)
        right = self.dfs2(node.right,target,ancestor)
        if right is True:
            return True
        del ancestor[0]
        return False

    def dfs(self, node):
        if node is None:
            return
        print(node.val)
        self.dfs(node.left)
        self.dfs(node.right)



test = Solution()

root = TreeNode(3)
root.left = TreeNode(5)
root.left.left = TreeNode(6)
root.left.right = TreeNode(2)
root.left.right.left = TreeNode(7)
root.left.right.right = TreeNode(4)
root.right = TreeNode(1)
root.right.left = TreeNode(0)
root.right.right = TreeNode(8)


test.lowestCommonAncestor(root,root.left.right.left,root.left.right.right)

