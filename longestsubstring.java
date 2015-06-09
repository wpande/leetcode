public class Solution {
    public int lengthOfLongestSubstring(String s) {
         HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
         int len=s.length();
         if(len==0)
            return 0;
         int i,j;
         i=0;
         j=0;
         int max=1;
         hm.put(s.charAt(j),0);
         while(j<len){
             if(j==len-1){
                 if(j-i+1>max)
                    max=j-i+1;
                 return max;
             }
             j=j+1;
             if(hm.containsKey(s.charAt(j))){
                 if(j-i>max){
                     max=j-i;
                 }
                 int newi=hm.get(s.charAt(j))+1;
                 for(int k=i;k<newi;k++)
                    hm.remove(s.charAt(k));
                 i=newi;
             }
            hm.put(s.charAt(j),j);
         }
         return max;
    }
}