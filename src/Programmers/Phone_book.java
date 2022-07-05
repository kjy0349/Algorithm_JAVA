package Programmers;
import java.util.*;
public class Phone_book {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String temp = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
            if (!phone_book[i].startsWith(temp)) temp = phone_book[i];
            else {
                answer = false;
                break;
            }
        }
        return answer;
    }
}
