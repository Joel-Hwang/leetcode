# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head == None or k == 1:
            return head

        nodes = []
        cur = head
        while cur is not None:
            nodes.append(cur)
            cur = cur.next
        
        i = 0
        while i + k <= len(nodes):
            self.reverse(nodes, i, i+k-1)
            i += k
        

        cur = nodes[0]
        for i in range(1,len(nodes)):
            cur.next = nodes[i]
            cur = cur.next
        nodes[-1].next = None
        return nodes[0]

    def reverse(self, nodes, start, end):
        for i in range( start, start + (int)((end-start)/2) + 1):
            temp = nodes[i]
            nodes[i] = nodes[start + end-i]
            nodes[start + end-i] = temp
    
    def reverseKGroup2(self, head, k):
        dummy = jump = ListNode(0)
        dummy.next = l = r = head
        
        while True:
            count = 0
            while r and count < k:   # use r to locate the range
                r = r.next
                count += 1
            if count == k:  # if size k satisfied, reverse the inner linked list
                pre, cur = r, l
                for _ in range(k):
                    cur.next, cur, pre = pre, cur.next, cur  # standard reversing
                jump.next, jump, l = pre, l, r  # connect two k-groups
            else:
                return dummy.next

head = ListNode(1)
head.next = ListNode(2)
#head.next.next = ListNode(3)
#head.next.next.next = ListNode(4)
#head.next.next.next.next = ListNode(5)
test = Solution()
test.reverseKGroup(head,2)
