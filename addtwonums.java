/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    int inc=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            if(inc==0)
                return l2;
            else{
                ListNode incnode=new ListNode(1);
                inc=0;
                incnode.next=null;
                return addTwoNumbers(incnode,l2);
            }
        }
        if(l2==null){
            if(inc==0)
                return l1;
            else{
                ListNode incnode=new ListNode(1);
                inc=0;
                incnode.next=null;
                return addTwoNumbers(l1,incnode);
            }
        }
        int tval=l1.val+l2.val+inc;
        if(tval>=10){
            inc=1;
            tval-=10;
        }
        else
            inc=0;
        ListNode res=new ListNode(tval);
        res.next=addTwoNumbers(l1.next,l2.next);   
        return res;
    }
}