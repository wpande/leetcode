public class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int area=Math.min(height[l],height[r])*(r-l);
        int tarea=0;
        while(l<r){
            if(height[l]<=height[r]){
                int nl=l+1;
                while(height[nl]<=height[l]&&nl<r) nl++;
                tarea=Math.min(height[nl],height[r])*(r-nl);
                area=tarea>area?tarea:area;
                l=nl;
            }
            else{
                int nr=r-1;
                while(height[nr]<=height[r]&&nr>l) nr--;
                tarea=Math.min(height[l],height[nr])*(nr-l);
                area=tarea>area?tarea:area;
                r=nr;
            }
        }
        return area;
    }
}