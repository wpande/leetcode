/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int len=points.length;
        if(len<=1)
            return len;
        int res=2;
        int cnt=0;
        HashMap<Double,Integer> hm=new HashMap<Double,Integer>();
        for(int i=0;i<len;i++)
            if(hm.containsKey((double)(points[i].x))){
                cnt=hm.get((double)(points[i].x));
                hm.put((double)(points[i].x),cnt+1);
            }
            else
                hm.put((double)(points[i].x),1);
        for(Map.Entry<Double, Integer> ent:hm.entrySet()){
            if(ent.getValue()>res)
                res=ent.getValue();
        }
        for(int i=0;i<len-1;i++){
            hm.clear();
            int bufx=points[i].x;
            int bufy=points[i].y;
            int surplus=1;
            for(int j=i+1;j<len;j++){
                if(points[j].x!=bufx){
                    double db=(double)(points[j].y-bufy)/(points[j].x-bufx);
                    if(Math.abs(db)<1e-7)
                        db=0.0;
                    if(hm.containsKey(db)){
                        cnt=hm.get(db);
                        hm.put(db,cnt+1);
                    }
                    else
                        hm.put(db,1);
                }
                else if(points[j].y==bufy)
                    surplus++;
            }
            for(Map.Entry<Double, Integer> ent:hm.entrySet()){
                if(ent.getValue()+surplus>res)
                    res=ent.getValue()+surplus;
            }
        }
        return res;
    }
}