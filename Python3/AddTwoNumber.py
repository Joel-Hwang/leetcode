import math
 class ListNode:
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution:
class AddTwoNumber:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        p = l1
        q = l2
        dummyHead = ListNode()
        curr = dummyHead
        carry = 0
        while p or q:
            x = p.val if p else 0
            y = q.val if q else 0
            sum = x+y+carry
            curr.next = ListNode(sum%10)
            curr = curr.next
            carry = math.floor(sum//10)
            if p:
                p = p.next
            if q:
                q = q.next
        if carry > 0:
            curr.next = ListNode(carry)
        return dummyHead.next


            
 