package backjoon;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baby_shark {
    public static class Coordinate{
        int y;
        int x;
        int distance;

        Coordinate(int y, int x, int distance){
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] space = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        int x = 0;
        int y = 0;
        int answer = 0;
        int e_count = 0;
        int size = 2;
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        StringTokenizer st;
        Queue<Coordinate> fishes = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) {
                if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.distance, o2.distance);
        });
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
                if(space[i][j] == 9){
                    y = i;
                    x = j;
                    visited[i][j] = true;
                    space[i][j] = 0;
                }
            }
        }
        fishes.add(new Coordinate(y, x, 0));
        while(!fishes.isEmpty()){
            Coordinate coor = fishes.poll();
            for(int i=0;i<4;i++){
                int oy = coor.y + dy[i];
                int ox = coor.x + dx[i];
                if(!(oy >= 0 && ox >= 0 && ox < N && oy < N)) continue;
                if(visited[oy][ox]) continue;
                visited[oy][ox] = true;
                if(space[oy][ox] <= size) fishes.add(new Coordinate(oy, ox, coor.distance + 1));
            }
            if (!fishes.isEmpty()){
                coor = fishes.peek();
                if(space[coor.y][coor.x] < size && space[coor.y][coor.x] != 0){
                    e_count += 1;
                    if(e_count == size){
                        size += 1;
                        e_count = 0;
                    }
                    space[coor.y][coor.x] = 0;
                    fishes.clear();
                    fishes.add(new Coordinate(coor.y, coor.x, 0));
                    answer += coor.distance;
                    visited = new boolean[N][N];
                    visited[coor.y][coor.x] = true;
                }
            }
        }
        System.out.println(answer);
    }
}
