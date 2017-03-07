/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode odd = head, oddTemp = head, even = head.next, evenTemp = head.next;
        while(oddTemp.next!=null && oddTemp.next.next!=null){
            oddTemp.next=oddTemp.next.next;
            oddTemp=oddTemp.next;
            evenTemp.next=evenTemp.next.next;
            evenTemp=evenTemp.next;
        }
        oddTemp.next=even;
        return odd;
    }
}