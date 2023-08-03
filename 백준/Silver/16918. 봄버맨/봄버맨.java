import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void plant(int x) { //  x == 3 : plant, x == 0 :
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = x;
                } else arr[i][j]--;
            }
        }
    }

    public static void tick() { //  x == 3 : plant, x == 0 :
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) {
                    arr[i][j]--;
                    if (arr[i][j] == 0) {
                        for (int k = 0; k < dx.length; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                                if (arr[nx][ny] != 1) {
                                    arr[nx][ny] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                String elem = Character.toString(line.charAt(j));
                if (elem.equals("O")) {
                    arr[i][j] = 3;
                } else if (elem.equals(".")) arr[i][j] = 0;
            }
        }
//        for (int[] elem : arr) System.out.println(Arrays.toString(elem));

        while (N > 0) {
            tick();
            N--;
//            for (int[] elem : arr) System.out.println(Arrays.toString(elem));
            if (N > 0) {
//                System.out.println();
                plant(3);
                N--;
//                for (int[] elem : arr) System.out.println(Arrays.toString(elem));
//                System.out.println();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > 0) sb.append("O");
                else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
