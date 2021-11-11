package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] lines = scan.nextLine().split(" ");
        ArrayList<Integer> person = new ArrayList<>();
        for(String line: lines) person.add(Integer.parseInt(line));
        int result = 0;
        int temporary_sum = 0;
        Collections.sort(person);
        for (int time: person) {
            temporary_sum += time;
            result += temporary_sum;
        }
        System.out.println(result);
    }
}
