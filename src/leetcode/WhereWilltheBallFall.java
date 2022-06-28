package leetcode;

import java.util.Arrays;

public class WhereWilltheBallFall {
        // 오른쪽으로 가라 -> 1, 왼쪽으로 가라 -> -1
    static int[][] grid = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
    public static void main(String[] args) {
        int[] ret_arr = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {// 각각의 공
            int x = 0;
            int y = i;
            while (x < grid.length) {
                int ny = y + grid[x][y];
                if (ny >= 0 && ny < grid[0].length) {
                    if (grid[x][y] == grid[x][y + grid[x][y]]) {
                        int elem = grid[x][y];
                        x++;
                        y += elem;
                    } else {
                        ret_arr[i] = -1;
                        break;
                    }
                } else {
                    ret_arr[i] = -1;
                    break;
                }
            }
            if (ret_arr[i] != -1) ret_arr[i] = y;
        }
    }
}
