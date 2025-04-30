package interview;

import java.util.HashMap;
import java.util.Set;

public class AmazonOA {

    public static int countElements(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = 0;
        Set<Integer> set = map.keySet();

        for(int i : set){
           int freq = map.get(i);
           if(freq>max)max = freq;
        }

        return n - max;
    }
}
