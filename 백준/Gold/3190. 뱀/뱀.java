import java.util.*;
import java.io.*;

public class Main {
    public static int turn_right(int direction){
        if(direction == 3) return 0;
        else return direction + 1;
    }
    public static int turn_left(int direction){
        if(direction == 0) return 3;
        else return direction -1;
    }

    public static int[] step(int[][] map, int x, int y, int direction){
        switch(direction){
            case 0:
                if(map.length - 1 >= 0) return new int[]{x-1, y};
                else throw new RuntimeException("got blocked");
            case 1:
                if(y+1 < map[x].length) return new int[]{x, y+1};
                else throw new RuntimeException("got blocked");
            case 2:
                if(x+1 < map.length) return new int[]{x+1, y};
                else throw new RuntimeException("got blocked");
            case 3:
                if(y - 1 >= 0) return new int[]{x, y-1};
                else throw new RuntimeException("got blocked");
            default:
                System.out.println("Error");
                return new int[]{};
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int apple_count = Integer.parseInt(br.readLine());
        Deque<int[]> snake = new ArrayDeque<>();
        String[] cord;
        HashMap<Integer, String> direction_info = new HashMap<>();
        int direction = 1; // 동쪽
        int tick = 0;
        int[] coordinate = new int[2];
        for (int i = 0; i < apple_count; i++) { // 사과가 있는 좌표의 값은 2
            cord = br.readLine().split(" ");
            map[Integer.parseInt(cord[0]) - 1][Integer.parseInt(cord[1]) - 1] = 2;
        }
        int M = Integer.parseInt(br.readLine());
        String[] input;
        int[] tail_cord;
        for (int i = 0; i < M; i++) { // 방향 전환 정보
            input = br.readLine().split(" ");
            direction_info.put(Integer.parseInt(input[0]), input[1]);
        }
        map[0][0] = 1;
        snake.add(new int[]{0, 0});
        try {
            while (true) {
                tick++;
                coordinate = step(map, coordinate[0], coordinate[1], direction);
                if (map[coordinate[0]][coordinate[1]] == 2) {
                    map[coordinate[0]][coordinate[1]] = 1;
                    snake.addLast(new int[]{coordinate[0], coordinate[1]});
                } else if (map[coordinate[0]][coordinate[1]] == 1) {
                    throw new RuntimeException("got body block");
                } else {
                    snake.addLast(new int[]{coordinate[0], coordinate[1]});
                    map[coordinate[0]][coordinate[1]] = 1;
                    tail_cord = snake.poll();
                    assert tail_cord != null;
                    map[tail_cord[0]][tail_cord[1]] = 0;
                }
                if (direction_info.containsKey(tick)) {
                    if (direction_info.get(tick).equals("L")) direction = turn_left(direction);
                    if (direction_info.get(tick).equals("D")) direction = turn_right(direction);
                }
            }
        } catch (Exception e) {
            System.out.println(tick);
        }
    }
}