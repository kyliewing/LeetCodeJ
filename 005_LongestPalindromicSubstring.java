//O(n^2) Solution, Strat checking from the middle. AC
public class Solution {
    public String longestPalindrome(String s) {
        String res = new String();
        char[] chars=s.toCharArray();
        for(int i=0;i<s.length();i++){
            //for odd substrings.
            String temp1=check(s,i,i);
            if (temp1.length()>res.length())
                res=temp1;
            //for even substrings.
            String temp2=check(s,i,i+1);
            if (temp2.length()>res.length())
                res=temp2;
        }
        return res;
    }
    
    public String check(String s, int l , int r){
        char[] chars=s.toCharArray();
        while(l>=0 && r<s.length() && chars[l]==chars[r]){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}

//O(n^2) Solution, Strat checking from the middle and start checking the longest one.
public class Solution{
    public String longestPalindrome(String s){
        char[] ss=s.toCharArray();
        int rLen=s.length();
        while(rLen>0){
            for(int i=0;i<s.length()-rLen+1;i++){
                int left=i, right=i+rLen-1;
                boolean flag=true;
                while(left<right){
                    if(ss[left]!=ss[right]){
                        flag=false;
                        break;
                    }
                    left++;
                    right--;
                }
                if(flag==true){
                    return s.substring(i,i+rLen);
                }
            }
            rLen--;
        }
        return "";
    }
}



