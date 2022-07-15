package sort;

import java.util.Arrays;

public class SortTimeTest {
    public static void main(String[] args) {
        int N = 100000000;
        long beforeTime = System.currentTimeMillis();
        CountingSort.main(new String[]{}, N);
        long afterTime = System.currentTimeMillis();
        long secTime = (afterTime - beforeTime)/1000L;
        System.out.println(secTime);
        beforeTime = System.currentTimeMillis();
        QuickSort.main(new String[]{}, N);
        afterTime = System.currentTimeMillis();
        secTime = (afterTime - beforeTime) / 1000L;
        System.out.println(secTime);
    }
}
