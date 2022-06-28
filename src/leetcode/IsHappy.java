package leetcode;
import java.util.*;

public class IsHappy {
    public boolean isHappy(int n) {
        String num = Integer.toString(n);
        if (num.charAt(0) - '0' > 0) {
            int result = 0;
            HashSet<Integer> set = new HashSet<>();
            int sub_sum = 0;
            while (true) {
                for (int i = 0; i < num.length(); i++) {
                    int pow = num.charAt(i) - '0';
                    sub_sum += pow * pow;
                }
                if (sub_sum == 1) return true;
                else {
                    if (!set.contains(sub_sum)) {
                        set.add(sub_sum);
                        num = Integer.toString(sub_sum);
                        sub_sum = 0;
                    } else return false;
                }
            }
        } else return false;
    }
}
