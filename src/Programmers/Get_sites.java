package Programmers;
import java.util.*;
public class Get_sites {
    class Solution {
        class Cord {
            int x;
            int y;
            Cord (int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public int bfs(int x, int y, int[][] picture, boolean[][] visited) {
            Queue<Cord> q = new LinkedList<>();
            Cord cur = new Cord(x, y);
            q.add(cur);
            visited[cur.x][cur.y] = true;
            int count = 1;
            int[] dx = {1, 0, 0, -1};
            int[] dy = {0, 1, -1, 0};
            while (!q.isEmpty()) {
                Cord next = q.poll();
                for (int i = 0;i < 4;i++){
                    int nx = next.x + dx[i];
                    int ny = next.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < picture.length && ny < picture[0].length && picture[cur.x][cur.y] == picture[nx][ny] && !visited[nx][ny]) {
                        q.add(new Cord(nx, ny));
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
            return count;
        }

        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            boolean[][] visited = new boolean[100][100];
            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if (!visited[i][j] && picture[i][j] != 0) {
                        int max = bfs(i, j, picture, visited);
                        numberOfArea++;
                        if (max > maxSizeOfOneArea) maxSizeOfOneArea = max;
                    }
                }
            }
            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }
    }
}
