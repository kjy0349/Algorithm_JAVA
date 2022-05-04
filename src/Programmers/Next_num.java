package Programmers;
import java.util.*;
public class Next_num {
    // n보다 큰 자연수 중, 2진수로 변환했을 때 1의 개수가 같고, 해당 두 조건을 만족하는 수 중 최솟값
    static class Solution {
        public int get_count(int n) {
            ArrayList<Integer> nums = new ArrayList<>();
            int count = 0;
            while (n >= 2) {
                int num = n % 2;
                nums.add(num);
                n = n / 2;
                if (num == 1) count++;
            }
            nums.add(n % 2);
            return count;
        }
        public int solution(int n) {
            int answer = 0;
            int n_count = get_count(n);
            for (int i = n + 1;i <= 1000000;i++) {
                if (get_count(i) == n_count) {
                    answer = i;
                    break;
                }
            }
            return answer;
        }
    }
}
