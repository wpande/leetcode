public class Solution {
    class QuEle{
        int l;
        int r;
        int h;
        int no;
        QuEle(int left,int right,int height,int no){
            l=left;
            r=right;
            h=height;
            this.no=no;
        }
    }
    
    class Rcomp implements Comparator<QuEle>{
        public int compare(QuEle x, QuEle y){
            if(x.r<y.r)
                return -1;
            else if(x.r==y.r) 
                return 0;
            else 
                return 1;
        }
    }
    
    class Hcomp implements Comparator<QuEle>{
        public int compare(QuEle x, QuEle y){
            if(x.h>y.h)
                return -1;
            else if(x.h==y.h) 
                return 0;
            else 
                return 1;
        }        
    }
    
    List<int[]> getSkyline(int[][] buildings) {
        int lenx=buildings.length;
        List<int[]> res=new ArrayList<int[]>();
        if(lenx==0)
            return res;
        PriorityQueue<QuEle> rpq=new PriorityQueue<QuEle>(lenx,new Rcomp());
        PriorityQueue<QuEle> hpq=new PriorityQueue<QuEle>(lenx,new Hcomp());
        QuEle rbuf=null;
        QuEle hbuf=null;
        for(int i=0;i<lenx;i++){
            QuEle qe=new QuEle(buildings[i][0],buildings[i][1],buildings[i][2],i);
            rbuf=rpq.isEmpty()?null:rpq.peek();
            while(rbuf!=null&&rbuf.r<qe.l){
                rbuf=rpq.poll();
                hbuf=hpq.peek();
                if(rbuf.no==hbuf.no){
                	hpq.poll();
                    QuEle next=hpq.isEmpty()?null:hpq.peek();
                    int[] buf={rbuf.r,next==null?0:next.h};
                    res.add(buf);
                }
                else
                	hpq.remove(rbuf);
                rbuf=rpq.isEmpty()?null:rpq.peek();
            }
            rpq.add(qe);
            hpq.add(qe);
            hbuf=hpq.peek();
            if(qe.no==hbuf.no){
                int[] buf={qe.l,qe.h};
                res.add(buf);
            }
        }
        rbuf=rpq.isEmpty()?null:rpq.peek();
        while(rbuf!=null){
            rbuf=rpq.poll();
            hbuf=hpq.peek();
            if(rbuf.no==hbuf.no){
            	hpq.poll();
                QuEle next=hpq.isEmpty()?null:hpq.peek();
                int[] buf={rbuf.r,next==null?0:next.h};
                res.add(buf);
            }
            else 
            	hpq.remove(rbuf);
            rbuf=rpq.isEmpty()?null:rpq.peek();
        }
        int upper=res.size();
        for(int i=1;i<upper;i++){
        	if(res.get(i)[0]==res.get(i-1)[0]){
        		res.remove(i-1);
        		i--;
        		upper--;
        	}
        	else if(res.get(i)[1]==res.get(i-1)[1]){
                res.remove(i);
                i--;
                upper--;
            }
        }
        return res;
    }
}