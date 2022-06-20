package leetcode;
import java.util.*;
public class LongPressedName {
        public boolean isLongPressedName(String name, String typed) {
            int n_ind = 0; // name index
            int t_ind = 0; // typed index
            while (n_ind < name.length() && t_ind < typed.length()) {
                if (name.charAt(n_ind) == typed.charAt(t_ind)) {
                    n_ind++;
                    t_ind++;
                } else if (n_ind > 0) {
                    if (name.charAt(n_ind - 1) == typed.charAt(t_ind)) {
                        t_ind++;
                    } else return false;
                } else return false;
            }
            while (t_ind < typed.length() && name.charAt(name.length() - 1) == typed.charAt(t_ind))
            {
                t_ind++;
            }
            if (n_ind == name.length() && t_ind == typed.length()) return true;
            else return false;
        }
}
