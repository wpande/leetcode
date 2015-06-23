public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> qu=new LinkedList<String>();
        int level=0;
        wordDict.remove(beginWord);
        qu.add(beginWord);
        qu.add("");
        while(!qu.isEmpty()){
            String buf=qu.poll();
            int len=buf.length();
            if(len!=0){
                char[] chars=buf.toCharArray();
                for(int i=0;i<len;i++){
                    char temp=chars[i];
                    for(char ch='a';ch<='z';ch++)
                        if(ch!=temp){
                            chars[i]=ch;
                            buf=String.valueOf(chars);
                            if(endWord.equals(buf))
                                return level+2;
                            if(wordDict.contains(buf)){
                                qu.add(buf);
                                wordDict.remove(buf);
                            }
                        }
                    chars[i]=temp;
                }
            }
            else{
                if(!qu.isEmpty()){
                    qu.add("");
                    level++;
                }
            }
        }
        return 0;
    }
}