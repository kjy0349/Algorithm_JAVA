package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_20327 {
    public static int[][] op1(int[][] sub_ar) {
        int[][] b = new int[sub_ar.length][sub_ar.length];
        for (int i = 0;i < b.length;i++) System.arraycopy(sub_ar[i], 0, b[b.length - i - 1], 0, b[0].length);
        return b;
    }

    public static int[][] op2(int[][] sub_ar) {
        int[][] b = new int[sub_ar.length][sub_ar.length];
        for (int i = 0;i < b.length;i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = sub_ar[i][b[0].length - j - 1];
            }
        }
        return b;
    }

    public static int[][] op3(int[][] sub_ar) {
        int[][] b = new int[sub_ar.length][sub_ar.length];
        for (int i = 0;i < b.length;i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = sub_ar[b.length - j - 1][i];
            }
        }
        return b;
    }

    public static int[][] op4(int[][] sub_ar) {
        int[][] b = new int[sub_ar.length][sub_ar.length];
        for (int i = 0;i < b.length;i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = sub_ar[j][b.length - i - 1];
            }
        }
        return b;
    }

    public static void op1_to_op4(int[][] array, int c_num, int cx, int cy, int sub_size) {
        int[][] b = new int[sub_size][sub_size];
        for (int i = 0;i < sub_size;i++) {
            for (int j = 0; j < sub_size; j++) b[i][j] = array[cx + i][cy + j];
        }
        switch (c_num) {
            case 1:
                b = op1(b);
                break;
            case 2:
                b = op2(b);
                break;
            case 3:
                b = op3(b);
                break;
            case 4:
                b = op4(b);
        }
        for (int i = 0;i < b.length;i++) {
            for (int j = 0; j < b[0].length; j++) array[cx + i][cy + j] = b[i][j];
        }
    }

    public static int[][] op5(int[][] array, int l) {
        int j_size = (1 << l);
        int[][] b = new int[array.length][array[0].length];
        int sub_count = array.length / j_size;
        for (int i = 0; i < sub_count; i++) {
            for (int j = 0; j < sub_count; j++) {
                int x1 = i * j_size;
                int y1 = j * j_size;
                int x2 = (sub_count - i - 1) * j_size;
                int y2 = y1;
                for (int x = 0; x < j_size; x++) {
                    for (int y = 0; y < j_size; y++) b[x1 + x][y1 + y] = array[x2 + x][y2 + y];
                }
            }
        }
        return b;
    }

    public static int[][] op6(int[][] array, int l) {
        int j_size = (1 << l);
        int[][] b = new int[array.length][array[0].length];
        int sub_count = array.length / j_size;
        for (int i = 0; i < sub_count; i++) {
            for (int j = 0; j < sub_count; j++) {
                int x1 = i * j_size;
                int y1 = j * j_size;
                int x2 = x1;
                int y2 = (sub_count - j - 1) * j_size;
                for (int x = 0; x < j_size; x++) {
                    for (int y = 0; y < j_size; y++) b[x1 + x][y1 + y] = array[x2 + x][y2 + y];
                }
            }
        }
        return b;
    }

    public static int[][] op7(int[][] array, int l) {
        int j_size = (1 << l);
        int[][] b = new int[array.length][array[0].length];
        int sub_count = array.length / j_size;
        for (int i = 0; i < sub_count; i++) {
            for (int j = 0; j < sub_count; j++) {
                int x1 = i * j_size;
                int y1 = j * j_size;
                int x2 = (sub_count - j - 1) * j_size;
                int y2 = x1;
                for (int x = 0; x < j_size; x++) {
                    for (int y = 0; y < j_size; y++) b[x1 + x][y1 + y] = array[x2 + x][y2 + y];
                }
            }
        }
        return b;
    }

    public static int[][] op8(int[][] array, int l) {
        int j_size = (1 << l);
        int[][] b = new int[array.length][array[0].length];
        int sub_count = array.length / j_size;
        for (int i = 0; i < sub_count; i++) {
            for (int j = 0; j < sub_count; j++) {
                int x1 = i * j_size;
                int y1 = j * j_size;
                int x2 = y1;
                int y2 = (sub_count - i - 1) * j_size;
                for (int x = 0; x < j_size; x++) {
                    for (int y = 0; y < j_size; y++) b[x1 + x][y1 + y] = array[x2 + x][y2 + y];
                }
            }
        }
        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int R = inputs[1];
        int[][] array = new int[(int)Math.pow(2, N)][(int)Math.pow(2, N)];
        for (int i = 0;i < (int)Math.pow(2, N);i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0;j < (int)Math.pow(2, N);j++) array[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0;i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c_num = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int sub_size = (1 << l);
            if (c_num >= 1 && c_num <= 4) {
                for (int j = 0; j < array.length; j += sub_size) {
                    for (int k = 0; k < array[0].length; k += sub_size) op1_to_op4(array, c_num, j, k, sub_size);
                }
            } else {
                switch (c_num) {
                    case 5:
                        array = op5(array, l);
                        break;
                    case 6:
                        array = op6(array, l);
                        break;
                    case 7:
                        array = op7(array, l);
                        break;
                    case 8:
                        array = op8(array, l);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] elem : array) {
            sb.append(elem[0]);
            for (int j = 1; j < elem.length; j++) sb.append(" ").append(elem[j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
