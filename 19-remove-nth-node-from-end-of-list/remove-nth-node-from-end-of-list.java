/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int l=0;
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        temp=head;
        if(l==1 && n==1){
            head=null;
            return head;
        }
        if(l==n){
            head=head.next;
            return head;
        }
        int idx=l-n;
        for(int i=0; i<idx-1; i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;

        
    }
}