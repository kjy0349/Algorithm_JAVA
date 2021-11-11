package Programmers;

import java.util.Scanner;
public class Sugar_Delivery_easy{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int result = 0;
        while(true){
            if(N % 5 == 0){
                result += N / 5;
                System.out.println(result);
                break;
            }
            else{
                N -= 3;
                result += 1;
            }
            if(N < 0){
                System.out.println(-1);
                break;
            }
        }
    }
}
