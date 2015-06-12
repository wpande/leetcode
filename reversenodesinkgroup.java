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
    void reversek(ListNode head,int k){
        cnt++;
        if(head.next==null){
            cnt=(cnt-1)%k;
            cnt=-cnt;
            return;
        }
        reversek(head.next,k);
        if(++cnt==k){
            cnt=0;
            ListNode[] ln=new ListNode[k];
            ListNode p=head;
            for(int i=0;i<k;i++){
                ln[i]=p.next;
                p=p.next;
            }
            ln[0].next=ln[k-1].next;
            head.next=ln[k-1];
            for(int i=k-1;i>0;i--)
                ln[i].next=ln[i-1];
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode phantom=new ListNode(0);
        phantom.next=head;
        reversek(phantom,k);
        return phantom.next;
    }
}