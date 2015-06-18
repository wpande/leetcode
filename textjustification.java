public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<String>();
        int len=words.length;
        int idx=0;
        StringBuffer sb=new StringBuffer();
        while(idx<len){
            sb.setLength(0);
            int wid=0;
            int wordlen=0;
            int i=0;
            int wcnt=0;
            for(i=idx;i<len;i++){
                wid+=words[i].length();
                wordlen+=words[i].length();
                wcnt++;
                if(wid>=maxWidth)
                    break;
                else
                    wid++;
            }
            if(i<len){
            	if(wid!=maxWidth){
	                wid-=words[i].length();
	                wordlen-=words[i].length();
	                wcnt--;
            	}
            	else
            		i++;
                if(wcnt==1){
                    sb.append(words[idx]);
                    for(int j=0;j<maxWidth-wordlen;j++)
                        sb.append(' ');
                }
                else{
                    int div=(maxWidth-wordlen)/(wcnt-1);//div should add1
                    int extra=(maxWidth-wordlen)%(wcnt-1);
                    for(int j=idx;j<idx+extra;j++){
                        sb.append(words[j]);
                        for(int k=0;k<div+1;k++)
                            sb.append(' ');
                    }
                    for(int j=idx+extra;j<i-1;j++){
                        sb.append(words[j]);
                        for(int k=0;k<div;k++)
                            sb.append(' ');
                    }
                    sb.append(words[i-1]);
                }
                idx=i;
            }
            else{
                for(int j=idx;j<len;j++){
                    sb.append(words[j]);
                    sb.append(' ');
                }
                for(int j=0;j<maxWidth-wid;j++)
                	sb.append(' ');
                idx=i;
            }
            res.add(sb.toString());
        }
        return res;
    }
}