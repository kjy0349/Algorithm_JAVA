package leetcode;
import java.util.*;
public class SpiralMatrix {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> ret_arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        int direction = 0;
        while (true) {
            while (!visited[i][j]) {
                visited[i][j] = true;
                ret_arr.add(matrix[i][j]);
                if (i + dx[direction] >= 0 && i + dx[direction] < matrix.length &&
                        j + dy[direction] >= 0 && j + dy[direction] < matrix[0].length && !visited[i + dx[direction]][j + dy[direction]])
                {
                    i += dx[direction];
                    j += dy[direction];
                }
            }
            direction = (direction + 1) % 4;
            int nx = i + dx[direction];
            int ny = j + dy[direction];
            if (!(nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[0].length) || visited[nx][ny]) break;
            else {
                i = nx;
                j = ny;
            }
        }
        return ret_arr;
    }
}
