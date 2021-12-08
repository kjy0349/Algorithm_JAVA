package standard;
import java.util.*;
public class Test {
    public static void main(String[] args){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        map.put(0, one);
        System.out.println(map.get(0));
    }
}
