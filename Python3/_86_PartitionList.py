# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        small = []
        big = []
        cur = head
        while cur is not None:
            if cur.val < x:
                small.append(cur)
            else:
                big.append(cur)
            cur = cur.next

        res = ListNode(0)
        curRes = res
        for node in small:
            curRes.next = node
            curRes = curRes.next
        for node in big:
            curRes.next = node
            curRes = curRes.next
        curRes.next = None
        return res.next

