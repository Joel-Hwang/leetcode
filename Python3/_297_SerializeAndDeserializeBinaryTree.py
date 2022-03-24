# Definition for a binary tree node.
from typing import Dict


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    gid = 0
    def serialize(self, root:TreeNode):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        self.gid = 0
        return self.dfs(root)
        

    def dfs(self, node:TreeNode) -> str:
        if node is None:
            return ""
        res = str(self.gid)+":"+str(node.val)
        self.gid += 1
        res += ":"+str(self.gid)
        left = ","+self.dfs(node.left)
        
        self.gid += 1
        res += ":"+str(self.gid)
        right = ","+self.dfs(node.right)
        
        return res+left+right
    
        

    def deserialize(self, data:str)->TreeNode:
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "":
            return None
        nodes = data.split(',')
        nodeMap = {}
        nodeChildMap = {}
        for node in nodes:
            if node == "":
                continue
            nodeInfo = node.split(':')
            nodeMap[int(nodeInfo[0])] = TreeNode(int(nodeInfo[1]))
            nodeChildMap[int(nodeInfo[0])] = [int(nodeInfo[2]),int(nodeInfo[3])]
        
        root = nodeMap[0]
        self.addChildren(0,root,nodeMap,nodeChildMap)
        return root
    def addChildren(self, id:int,node:TreeNode,nodeMap:Dict,nodeChildMap:Dict)->None:
        leftId = nodeChildMap[id][0]
        rightId = nodeChildMap[id][1]

        if leftId in nodeMap:
            node.left = nodeMap[ leftId ]
            self.addChildren(leftId,node.left,nodeMap,nodeChildMap)
        if rightId in nodeMap:
            node.right = nodeMap[ rightId ]
            self.addChildren(rightId,node.right,nodeMap,nodeChildMap)


ser = Codec()
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

data = ser.serialize(root)
print(data)

deser = Codec()
ans = deser.deserialize(data)
print(ans)
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))