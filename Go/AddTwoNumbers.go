package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummyHead := ListNode{}
	curr := &dummyHead
	p := l1
	q := l2
	carry := 0

	for p != nil || q != nil {
		var x, y int
		if p != nil {
			x = p.Val
		} else {
			x = 0
		}

		if q != nil {
			y = q.Val
		} else {
			y = 0
		}

		sum := x + y + carry
		carry = sum / 10
		curr.Next = &ListNode{sum % 10, nil}
		curr = curr.Next

		if p != nil {
			p = p.Next
		}
		if q != nil {
			q = q.Next
		}
	}

	if carry > 0 {
		curr.Next = &ListNode{carry, nil}
	}

	return dummyHead.Next

}
