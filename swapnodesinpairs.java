/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int cnt=0;
    void recswap(ListNode head){
        cnt++;
        if(head.next==null){
            if(cnt%2==0)
                cnt=-1;
            else
                cnt=0;
            return;
        }
        recswap(head.next);
        if(++cnt==2){
            cnt=0;
            ListNode p=head.next;
            ListNode q=p.next;
            p.next=q.next;
            q.next=p;
            head.next=q;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode phantom=new ListNode(0);
        phantom.next=head;
        recswap(phantom);
        return phantom.next;
    }
}