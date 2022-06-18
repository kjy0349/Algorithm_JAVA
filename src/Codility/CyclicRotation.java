// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
package Codility;
import java.util.*;

class CyclicRotation {
    public int[] solution(int[] A, int K) {
        ArrayList<Integer> sol = new ArrayList<>();
        int[] ret_arr = new int[A.length];
        if (A.length == 0) return ret_arr;
        int index;
        if (K != 0) index = A.length - (K % A.length);
        else index = 0;
        for (int i = index; i < A.length; i++) sol.add(A[i]);
        for (int i = 0; i < index; i++) sol.add(A[i]);
        for (int i = 0; i < sol.size(); i++) ret_arr[i] = sol.get(i);
        return ret_arr;
    }
}
