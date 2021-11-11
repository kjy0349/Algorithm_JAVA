package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static boolean isPrime(int num){
        boolean is_prime = true;
        for(int i=num/2;i<num;i++){
            if (num%i==0){
                is_prime = false;
                break;
            }
        }
        return is_prime;
    }
    public static void main(String[] args){
        ArrayList<String> str = new ArrayList<>() {
            {
                add("ala");
                add("maa");
                add("cmd");
            }
        };
        System.out.println(str);
        String joined = String.join("", str);
        System.out.println(joined);
    }
}
