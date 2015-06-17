     public static boolean isMatch(String s, String p) {
        int lens=s.length();
        int lenp=p.length();
        if(lens<1||lenp<1)
            return false;
        boolean[] pmatch=new boolean[lens+1];
        boolean[] match=new boolean[lens+1];
        pmatch[0]=true;
        for(int i=1;i<=lenp;i++){
            char pc=p.charAt(i-1);
            int j;
            for(j=1;j<=lens;j++){
                if(pc=='?'){
                    match[j]=pmatch[j-1];
                }
                else if(pc=='*'){
                    match[j]=pmatch[j]||pmatch[j-1];
                }
                else{//character
                    if(p.charAt(i-1)==s.charAt(j-1))
                        match[j]=pmatch[j-1];
                }
                pmatch[j-1]=match[j-1];
            }
            pmatch[j-1]=match[j-1];
        }
        return match[lens];
    }