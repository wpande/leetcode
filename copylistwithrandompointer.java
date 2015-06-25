/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        HashMap<RandomListNode, RandomListNode> hm=new HashMap<RandomListNode, RandomListNode>();
        RandomListNode nhead=new RandomListNode(head.label);
        hm.put(head,nhead);
        RandomListNode shead=head;
        RandomListNode res=nhead;
        while(head!=null){
            RandomListNode nprior=nhead;
            head=head.next;
            if(head!=null){
                nhead=new RandomListNode(head.label);
                nprior.next=nhead;
                hm.put(head,nhead);
            }
            else
                nprior.next=null;
        }
        head=shead;
        nhead=res;
        while(head!=null){
            nhead.random=head.random==null?null:hm.get(head.random);
            head=head.next;
            nhead=nhead.next;
        }
        return res;
    }
}