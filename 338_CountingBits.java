
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=1; i<=num; i++){
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }
}

public class Solution{
    public int[] countBits(int num){
        int[] res = new int[num+1];
        int offset = 1;
        for (int i=1; i<=num; i++){
            if(i==offset*2) offset*=2;
            res[i]=res[i-offset]+1;
        }
        return res;
    }
}