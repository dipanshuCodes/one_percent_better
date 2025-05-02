package binarysearch.assignment;

public class PaintersPartitionProblem {
    int MOD = 10000003;
    public int paint(int A, int B, int[] C){

        long sum = 0;
        long max = 0;
        for(int i : C){
            sum= (sum+i);
            max = Math.max(max, i);
        }
        long minTime = (max%MOD * B%MOD)%MOD;
        long maxTime = (sum%MOD *B%MOD)%MOD;
        long ans = maxTime;
        while(minTime <= maxTime){
            long mid = minTime + (maxTime - minTime)/2;
            int cnt = countOfPainters(mid, B, C);
            if(cnt<=A){
                ans = mid;
                maxTime = mid-1;
            }
            else
                minTime = mid+1;
        }

        return (int)(ans%MOD);
    }

    private int countOfPainters(long X, int B, int[] C){
        int cnt = 1;
        long time = X;
        for(int i : C){
            if((long)i *B > X) return -1;
            if((long)i *B <= time){
                time = (time - (long)i*B);
            }
            else{
                cnt+=1;
                time = (X - (long)i*B);
            }
        }
        return cnt;
    }
}
