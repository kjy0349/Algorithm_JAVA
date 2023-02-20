package study_42;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class P_1015 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) A[i] = scan.nextInt();
        int[] B = A.clone();
        Arrays.sort(B);
        boolean[] visited = new boolean[A.length];
        for (int elem : A){
            for (int j = 0; j < B.length; j++) {
                if (!visited[j] && elem == B[j]) {
                    bw.write(j + " ");
                    visited[j] = true;
                    break;
                }
            }
        }
        bw.flush();
    }
}