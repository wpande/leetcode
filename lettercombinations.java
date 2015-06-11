public class Solution {
    char [][]dict={{' '},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    int []dictlen={1,0,3,3,3,3,3,4,3,4};
    List<String> ls=new ArrayList<String>();
    public void enumerate(String digits,char []letters,int idx){
        if(idx==digits.length()){
            ls.add(String.valueOf(letters));
            return;
        }
        int len=dictlen[digits.charAt(idx)-'0'];
        for(int i=0;i<len;i++){
            letters[idx]=dict[digits.charAt(idx)-'0'][i];
            enumerate(digits,letters,idx+1);
        }
    }
    public List<String> letterCombinations(String digits) {
        char[] letters=new char[digits.length()];
        if(digits.length()==0)
            return ls;
        digits=digits.replaceAll("1","");
        enumerate(digits,letters,0);
        return ls;
    }
}