package leetcode;
import java.util.*;
public class TypeName {
    public static void main(String[] args) {
        String typed = "asdasd";
        StringBuilder sb = new StringBuilder();
        sb.append(typed.charAt(0));
        String a = sb.substring(sb.length() - 1);
        System.out.println(a);
    }
}
