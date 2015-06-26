public class LRUCache {
    class LinkNode{
        int key;
        int value;
        LinkNode prior;
        LinkNode next;
        LinkNode(int ky, int val,LinkNode pri,LinkNode nex){
            key=ky;
            value=val;
            prior=pri;
            next=nex;
        }
    }
    
    LinkNode head;
    int cap;
    int cnt;
    HashMap<Integer, LinkNode> hm;
    public LRUCache(int capacity) {
        head=new LinkNode(0,0,null,null);
        cap=capacity;
        cnt=0;
        hm=new HashMap<Integer, LinkNode>();
    }
    
    public int get(int key) {
        LinkNode ln=hm.get(key);
        if(ln==null)
            return -1;
        LinkNode next=ln.next;
        ln.prior.next=next;
        if(head.prior==ln)
            head.prior=ln.prior;
        if(next!=null)
            next.prior=ln.prior;
        ln.prior=head;
        ln.next=head.next;
        head.next=ln;
        if(head.prior==null||head.prior==head)
            head.prior=ln;
        LinkNode buf=ln.next;
        if(buf!=null){
            buf.prior=ln;
        }
        return ln.value;
    }
    
    public void set(int key, int value) {
        if(hm.containsKey(key)){
            LinkNode ln=hm.get(key);
            if(ln.value!=value)
                ln.value=value;
            LinkNode next=ln.next;
            ln.prior.next=next;
            if(head.prior==ln)
                head.prior=ln.prior;
            if(next!=null){
                next.prior=ln.prior;
            }
            ln.prior=head;
            ln.next=head.next;
            head.next=ln;
            LinkNode buf=ln.next;
            if(buf!=null){
                buf.prior=ln;
            }
        }
        else{
            if(cnt==cap){
                LinkNode tail=head.prior;
                if(tail==null)
                    return;
                else{
                    int ky=tail.key;
                    hm.remove(ky);
                    cnt--;
                    LinkNode pr=tail.prior;
                    pr.next=null;
                    head.prior=pr;
                }
            }
            LinkNode ln=new LinkNode(key,value,head,head.next);
            LinkNode next=head.next;
            if(head.prior==null||head.prior==head)
                head.prior=ln;
            if(next!=null)
                next.prior=ln;
            head.next=ln;
            hm.put(key,ln);
            cnt++;
        }
    }
}