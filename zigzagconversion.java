public class Solution {
    public String convert(String s, int numRows) {
        if(s==null||s.length()<2||numRows==1)
            return s;
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
            sb[i]=new StringBuffer();
        for(int i=0;i<s.length();i++){
            int idx=i%(2*numRows-2);
            if(idx>=numRows){
                idx=2*numRows-2-idx;
            }
            sb[idx].append(s.charAt(i));
        }
        String res=sb[0].toString();
        for(int i=1;i<numRows;i++)
            res+=sb[i].toString();
        return res;
    }
}