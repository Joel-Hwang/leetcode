from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        cur1 = head
        cur2 = head
        while cur2 != None and cur2.next != None:
            cur1 = cur1.next
            cur2 = cur2.next.next
        return cur1