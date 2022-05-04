package backjoon;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_15685 {
//    public static ArrayList<Integer> make_dirs(int[] dragon) {
//        int x = dragon[0];
//        int y = dragon[1];
//        int dir = dragon[2];
//        int count = dragon[3];
//        ArrayList<Integer> dirs = new ArrayList<>();
//        dirs.add(dir);
//        for (int i = 1; i <= count; i++) {
//
//        }
//    }

    public static void main(String[] args) throws IOException{
        // 0:동 1:북 2:서 3:남
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dragon = new int[4];
        int[][] map = new int[100][100];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < 4;j++) dragon[j] = Integer.parseInt(st.nextToken());

        }
    }
}
