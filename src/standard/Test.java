package standard;
import java.util.*;
public class Test {
    public static void main(String[] args){
        LinkedList<Integer> row = new LinkedList<>(){
            {
                add(1);
                add(5);
                add(6);
                add(2);
            }
        };
        LinkedList<Integer> col = new LinkedList<>(){
            {
                add(1);
                add(3);
                add(4);
            }
        };
        System.out.println(row.get(row.indexOf(2)+1));
    }
}
