/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean flag=false;
    int cnt=-1;
    public ListNode removenode(ListNode head,int n){
        if(head.next==null){
            flag=true;
            cnt=0;
            return head;
        }
        ListNode ln=removenode(head.next,n);
        if(flag&&++cnt==n){
            head.next=ln.next;
        }
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode phantom=new ListNode(0);
        phantom.next=head;
        return removenode(phantom,n).next;
    }
}