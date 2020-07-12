 function ListNode(val, next) {
     this.val = (val===undefined ? 0 : val)
     this.next = (next===undefined ? null : next)
 }
 

var addTwoNumbers = function(l1, l2) {
    let p = l1, q = l2, dummyHead = new ListNode(0);    
    let curr = dummyHead;
    let carry = 0;
    while(p || q){
        let x = p?p.val:0;
        let y = q?q.val:0;
        let sum = x + y + carry;
        curr.next = new ListNode(sum%10);
        curr = curr.next
        carry = Math.floor(sum/10);
        if(p)p = p.next;
        if(q) q = q.next;
    } 

    if(carry >0)
        curr.next = new ListNode(carry);

    return dummyHead.next;
};