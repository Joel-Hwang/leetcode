# Definition for singly-linked list.

from tkinter.messagebox import NO
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode(0,head)
        cursor = temp
        while cursor.next != None and cursor.next.next != None:
            a = cursor.next
            b = cursor.next.next
            cursor.next = b
            a.next = b.next
            b.next = a
            cursor = a
        return temp.next


test = Solution()

p1 = ListNode(1)
p2 = ListNode(2)
p3 = ListNode(3)
p4 = ListNode(4)
p1.next = p2
p2.next = p3
p3.next = p4

res = test.swapPairs(p1)