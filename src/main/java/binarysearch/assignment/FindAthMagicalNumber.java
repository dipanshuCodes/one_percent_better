package binarysearch.assignment;

public class FindAthMagicalNumber {

    static int GCD(int u, int v)
    {
        if (u == 0)
            return v;
        return GCD(v % u, u);
    }

    static int LCM(int x, int y){
        return (x/GCD(x,y)) * y;
    }

    boolean isPossible(int num, int a, int b){
        return (num%a==0 || num%b==0);
    }

    public int findAthMagicalNumber(int A, int B, int C) {
        int st = Math.min(B, C);
        int end = (A * Math.min(B, C));
        int lcm = LCM(B, C);
        while(st<=end){
            int mid = st + (end-st)/2;
            int check = mid/ B + mid/ C - mid/lcm;

            if(isPossible(mid, B, C) && check == A) return mid;
            if (check >= A) end = mid-1;
            else st = mid+1;
        }

        return -1;
    }

    // T.C = O(log(N*min(X,Y))
    // S.C = O(1)
}
