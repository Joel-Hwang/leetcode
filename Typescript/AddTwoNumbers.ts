


function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let p = l1, q = l2, dummyHead = new ListNode(0);
    let curr = dummyHead;
    let carry: number = 0;

    while (p || q ) {
        let x: number = (p !== null) ? p.val : 0;
        let y: number = (q !== null) ? q.val : 0;
        let sum: number = x + y + carry;
        curr.next = new ListNode(sum%10);
        curr = curr.next;
        carry = Math.floor(sum/10);

        if(p) p = p.next;
        if(q) q = q.next;
    }

    if(carry>0) curr.next = new ListNode(carry);
    return dummyHead.next;

};
 

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

(function (){
    let a:ListNode = new ListNode(2);
    a.next = new ListNode(4);
    a.next.next = new ListNode(3);
    let b:ListNode = new ListNode(5);
    b.next = new ListNode(6);
    b.next.next = new ListNode(4);
    console.log(addTwoNumbers(a,b));
})();
