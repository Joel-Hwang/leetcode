# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        nodes = []
        cur = head
        while cur is not None:
            nodes.append(cur)
            cur = cur.next
        ansList = []
        if len(nodes) == 0:
            return None
        k = len(nodes) - k
        for i in range(k,k+len(nodes)):
            ansList.append(nodes[i%len(nodes)])
        
        cur = ansList[0]
        for i in range(1,len(ansList)):
            cur.next = ansList[i]
            cur = cur.next
        ansList[len(ansList)-1].next =None
        return ansList[0]

    def rotateRight2(self, head: ListNode, k: int) -> ListNode:
        if not head:
            return None
        lastElement = head
        length = 1
        while ( lastElement.next ):
            lastElement = lastElement.next
            length += 1
        k = k % length
        lastElement.next = head
        tempNode = head
        for _ in range( length - k - 1 ):
            tempNode = tempNode.next
        answer = tempNode.next
        tempNode.next = None
        return answer
        
test = Solution()

head = ListNode(1)
head.next = ListNode(2)
head.next.next = ListNode(3)
head.next.next.next = ListNode(4)
head.next.next.next.next = ListNode(5)
test.rotateRight(head,2)
        