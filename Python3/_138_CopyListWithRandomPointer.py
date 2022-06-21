
# Definition for a Node.
from typing import Optional
from xml.dom.minicompat import NodeList


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: Optional[Node]) -> Optional[Node]:
        if head is None: return None
        map = {}
        cursor = head
        while cursor is not None:
            copiedNode = Node(cursor.val)
            map[cursor] = copiedNode
            cursor = cursor.next
        
        for k,v in map.items():
            if k.next is None: v.next = None
            else: v.next = map[k.next]
            if k.random is None: v.random = None
            else: v.random = map[k.random]
        
        return map[head]

test = Solution()

a = Node(1)
b = Node(2)
a.next = b
a.random = b
b.next = None
b.random = b
test.copyRandomList(a)
