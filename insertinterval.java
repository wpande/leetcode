/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    int findless(List<Interval> intervals, Interval newInterval){
        int len=intervals.size();
        if(len<1)
            return -1;
        int begin=0;
        int end=len-1;
        if(intervals.get(begin).start>=newInterval.start)
            return -1;
        if(intervals.get(end).start<=newInterval.start)
            return end;
        int mid=0;
        while(begin<=end){
            mid=(begin+end)/2;
            if(intervals.get(mid).start>newInterval.start)
                end=mid-1;
            else if(intervals.get(mid).start==newInterval.start)
                return mid;
            else
                begin=mid+1;
        }
        return end;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size()<1){
            intervals.add(newInterval);
            return intervals;
        }
        int begin=findless(intervals,newInterval);
        int len=intervals.size();
        if(begin==len-1){
            intervals.add(newInterval);
        }
        else
            intervals.add(begin+1,newInterval);
        Interval inter=null;
        int i=0;
        if(begin==-1){
            inter=newInterval;
            i=1;
        }
        else{
            inter=intervals.get(begin);
            i=begin+1;
        }
        Interval temp=intervals.get(i);
        if(temp.start>inter.end){
            i++;
            inter=temp;
        }
        for(;i<intervals.size();i++){
            temp=intervals.get(i);
            if(temp.start>inter.end)
                break;
            if(temp.end>inter.end){
                inter.end=temp.end;
            }
            intervals.remove(temp);
            i--;
        }
        
        return intervals;
    }
}