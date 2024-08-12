import java.util.*;
class Solution {
    class Oil {
        int size;
        Oil(int size) {
            this.size = size;
        }
    }
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public void bfs(int x, int y, boolean[][] visited, int[][] land, Oil[][] map) {
        int[] start = new int[]{x, y};
        visited[x][y] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        List<int[]> oils = new ArrayList<>();
        oils.add(start); queue.offer(start);
        int size = 1;
        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = target[0] + dx[i];
                int ny = target[1] + dy[i];
                if ((nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length) || visited[nx][ny] || land[nx][ny] == 0) continue;
                int[] next = new int[]{nx, ny};
                visited[nx][ny] = true;
                size++;
                oils.add(next); queue.offer(next);
            }
        }
        Oil oil = new Oil(size);
        for (int[] cord : oils) {
            map[cord[0]][cord[1]] = oil;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        boolean[][] visited = new boolean[land.length][land[0].length];
        Oil[][] map = new Oil[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(i, j, visited, land, map);
                }
            }
        }
        
        for (int y = 0; y < land[0].length; y++) {
            Set<Oil> oils = new HashSet<>();
            int result = 0;
            for (int x = 0; x < land.length; x++) {
                if (map[x][y] != null && !oils.contains(map[x][y])) {
                    oils.add(map[x][y]);
                    result += map[x][y].size;
                }
            }
            answer = Math.max(answer, result);
        }
        return answer;
    }
}