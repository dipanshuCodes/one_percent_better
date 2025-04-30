package interview;

import java.util.HashSet;

public class FNZGroup {
    /*
    * Statement :
    *   Given an aaray of n elements, find the total no. of unique products of all the elements by removing one element at a time.
    * */
    public static int uniqueProducts(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }

        return set.size();
    }
}
