    public static boolean isMatch(String s, String p) {
        int lens=s.length();
        int lenp=p.length();
        if(lens<1||lenp<1)
            return false;
        boolean[][] match=new boolean[lens+1][lenp+1];
        int[] cnt=new int[lenp];
        cnt[lenp-1]=0;
        for(int i=lenp-2;i>=0;i--)
            if(p.charAt(i+1)!='*')
                cnt[i]=cnt[i+1]+1;
        match[0][0]=true;
        for(int i=1;i<=lenp;i++){
            char pc=p.charAt(i-1);
            for(int j=1;j<=lens-cnt[i-1];j++){
                if(pc=='?'){
                    match[j][i]=match[j-1][i-1];
                }
                else if(pc=='*'){
                    match[j][i]=match[j][i-1]||match[j-1][i-1];
                }
                else{//character
                    if(p.charAt(i-1)==s.charAt(j-1))
                        match[j][i]=match[j-1][i-1];
                }
            }
        }
        return match[lens][lenp];
    }