
function ListNode(val, next) {
     this.val = (val===undefined ? 0 : val)
     this.next = (next===undefined ? null : next)
}
 
/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function(head, left, right) {
    left--;
    right--;
    let nodes = [];
    let cursor = head;
    while(cursor !== null){
        nodes.push(cursor);
        cursor = cursor.next;
    }

    for(let i = 0; i<(right-left+1)/2; i++){
        let temp = nodes[left+i];
        nodes[left+i] = nodes[right-i];
        nodes[right-i] = temp;
    }
    for(let i = 0; i<nodes.length-1; i++)
        nodes[i].next = nodes[i+1];
    nodes[nodes.length-1].next = null;
    return nodes[0];
};

var reverseBetween2 = function(head, left, right){
    let preStart = new ListNode(0,head);
    let preEnd = preStart;
    let start = head;
    for(let i = 0; i<left-1; i++){
        preEnd = start;
        start = start.next;
    }
    let end = start;
    let cursor = end;
    for(let i = left; i<right; i++){
        cursor = end.next;
        let post = cursor.next;
        preEnd.next = cursor;
        cursor.next = start;
        end.next = post;
        start = cursor;

    }

    return preStart.next;


    
    // 0-0-0-0-0
}

let head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
reverseBetween2(head,2,4);