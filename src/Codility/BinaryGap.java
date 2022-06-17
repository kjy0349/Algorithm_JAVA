package Codility;

public class BinaryGap {
    // MIN Distinct
    public static void main(String[] args) {
        int N = 1041;
        int num = 0;
        int size = 0;
        int temp = N;
        while (temp >= 2) {
            size++;
            temp /= 2;
        }
        size++;
        int seq = 0;
        while (num < size)
        {
            boolean find = false;
            if (((1 << num) & N) == 1 << num) {
                find = true;
                int sub_seq = 0;
                num++;
                while (num < size && ((1 << num) & N) == 0) {
                    sub_seq++;
                    num++;
                }
                if (sub_seq > seq) seq = sub_seq;
            }
            if (!find) num++;
        }
        System.out.println(seq);
    }
}