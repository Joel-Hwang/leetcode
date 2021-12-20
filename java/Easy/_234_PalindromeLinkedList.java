package Easy;

import java.util.ArrayList;

import CS.ListNode;

public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ArrayList ar = new ArrayList<>();
        ListNode temp =new ListNode();
        temp.next = head;
        while(temp.next != null){
            ar.add(temp.next.val);
            temp.next = temp.next.next;
        }

        for(int i = 0; i<ar.size()/2; i++){
            if(ar.get(i) != ar.get(ar.size()-1-i)) return false;
        }
        return true;
    }
}
