/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        Comparator<ListNode> cmp=new Comparator<ListNode>(){
            public int compare(ListNode n1,ListNode n2){
                return n1.val-n2.val;
            }  
        };
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(lists.length,cmp);
        ListNode phantom=new ListNode(0);
        ListNode p=phantom;
        HashMap<ListNode,Integer> hm=new HashMap<ListNode,Integer>();
        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null){
                pq.add(lists[i]);
                hm.put(lists[i],i);
                lists[i]=lists[i].next;
            }
        while(pq.peek()!=null){
            p.next=pq.poll();
            p=p.next;
            int idx=hm.get(p);
            hm.remove(p);
            if(lists[idx]!=null){
                pq.add(lists[idx]);
                hm.put(lists[idx],idx);
                lists[idx]=lists[idx].next;               
            }
        }
        return phantom.next;
    }
}