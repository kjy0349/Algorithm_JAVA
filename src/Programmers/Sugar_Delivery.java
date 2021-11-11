package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Sugar_Delivery{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        if (N < 3){
            System.out.println(-1);
        }
        else{
            int m_three, m_five;
            m_three = m_five = N;
            if (N % 3 == 0){
                m_three = N / 3;
            }
            if (N % 5 == 0){
                m_five = N / 5;
            }
            int finalM_three = m_three;
            int finalM_five = m_five;
            int compare = Collections.min(new ArrayList<>() {
                {
                    add(finalM_three);
                    add(finalM_five);

                }
            });
            int share_five = 1;
            ArrayList<Integer> arrays = new ArrayList<>();
            while (true){
                int temp = N;
                temp -= 5 * share_five;
                int share_three = temp / 3;
                if (share_five * 5 + share_three * 3 == N && share_five > 0 && share_three > 0){
                    arrays.add(share_five + share_three);
                }
                if (temp < 0){
                    break;
                }
                share_five += 1;
            }
            if (arrays.size() == 0 && compare == N){
                System.out.println(-1);
            }
            else if (compare == N){
                System.out.println(Collections.min(arrays));
            }
            else if (arrays.size() == 0){
                System.out.println(compare);
            }
            else{
                System.out.println(Collections.min(new ArrayList<Integer>(){
                    {
                        add(Collections.min(arrays));
                        add(compare);
                    }
                }));
            }
        }
    }
}
