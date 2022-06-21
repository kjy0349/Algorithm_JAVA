package leetcode;
import java.util.*;
class GoldMine {
    static class Cord {
        int x;
        int y;
        int gold;
        Cord (int x, int y, int gold) {
            this.x = x;
            this.y = y;
            this.gold = gold;
        }
    }

    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;
    static boolean[][] visited;

    public static void dfs(int i, int j, int gold) {
        if (gold > answer) answer = gold;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length &&
                    arr[nx][ny] > 0 && !visited[nx][ny])
            {
                visited[nx][ny] = true;
                dfs(nx, ny, gold + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    public int getMaximumGold(int[][] grid) {
        arr = grid;
        answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    visited = new boolean[grid.length][grid[0].length];
                    visited[i][j] = true;
                    dfs(i, j, arr[i][j]);
                }
            }
        }

        return answer;
    }
}