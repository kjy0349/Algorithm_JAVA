package backjoon;
import java.io.*;
import java.util.*;

public class Tetromino {
    public static int[] step(int[][] map, int x, int y, int direction, int answer){
        if(!Arrays.equals(new int[]{1001, 1001}, new int[]{x, y})){
            if(direction == 0) {
                if (0 <= x - 1) return new int[]{x - 1, y, answer + map[x - 1][y]};
                else return new int[]{1001, 1001, 0};
            } else if(direction == 1) {
                if (map[x].length > y + 1) return new int[]{x, y + 1, answer + map[x][y + 1]};
                else return new int[]{1001, 1001, 0};
            } else if(direction == 2) {
                if (map.length > x + 1) return new int[]{x + 1, y, answer + map[x + 1][y]};
                else return new int[]{1001, 1001, 0};
            } else {
                if (0 <= y - 1) return new int[]{x, y - 1, answer + map[x][y - 1]};
                else return new int[]{1001, 1001, 0};
            }
        } else return new int[]{1001, 1001, 0};
    }
    public static int turn_left(int direction){
        if(direction == 0){
            return 3;
        } else return direction - 1;
    }
    public static int turn_right(int direction){
        if(direction == 3){
            return 0;
        } else return direction + 1;
    }
    public static int first(int[][] map, int x, int y, int direction, int answer){ // 막대
        int[] cord = new int[]{x, y, answer + map[x][y]};
        for(int i=0;i<3;i++){
            if (Arrays.equals(cord, new int[]{1001, 1001})){
                return 0;
            } else cord = step(map, cord[0], cord[1], direction, cord[2]);
        }
        return cord[2];
    }
    public static int second(int[][] map, int x, int y, int direction, int answer){ // 박스
        int[] cord = new int[]{x, y, answer + map[x][y]};
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_right(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_right(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        return cord[2];
    }
    public static int third(int[][] map, int x, int y, int direction, int answer){ // h
        int[] cord = new int[]{x, y, answer + map[x][y]};
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_left(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_right(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        return cord[2];
    }
    public static int third_two(int[][] map, int x, int y, int direction, int answer){ // h
        int[] cord = new int[]{x, y, answer + map[x][y]};
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_right(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction = turn_left(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        return cord[2];
    }
    public static int fourth(int[][] map, int x, int y, int direction, int answer){ // ㄱ
        int[] cord = new int[]{x, y, answer + map[x][y]};
        for(int i=0;i<2;i++){
            cord = step(map, cord[0], cord[1], direction, cord[2]);
        }
        direction = turn_left(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        return cord[2];
    }
    public static int fourth_two(int[][] map, int x, int y, int direction, int answer){ // ㄱ
        int[] cord = new int[]{x, y, answer + map[x][y]};
        for(int i=0;i<2;i++){
            cord = step(map, cord[0], cord[1], direction, cord[2]);
        }
        direction = turn_right(direction);
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        return cord[2];
    }
    public static int fifth(int[][] map, int x, int y, int direction, int answer){ // ㅗ
        int[] cord = new int[]{x, y, answer + map[x][y]};
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        int[] temp = cord;
        int direction2 = direction;
        int answer2;
        answer2 = answer;
        int answer3;
        answer3 = answer;
        cord = step(map, cord[0], cord[1], direction, cord[2]);
        direction2 = turn_right(direction2);
        temp = step(map, temp[0], temp[1], direction2, answer2);
        return temp[2] + cord[2] - answer3;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        ArrayList<Integer> possibles = new ArrayList<>();
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[][] map = new int[N][M];
        // 0 - 북, 1 - 동, 2 - 남, 3 - 서
        for(int i=0;i<N;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                for(int z=0;z<4;z++){
                    possibles.add(first(map, i, j, z, 0));
                    possibles.add(second(map, i, j, z, 0));
                    possibles.add(third(map, i, j, z, 0));
                    possibles.add(third_two(map, i, j, z, 0));
                    possibles.add(fourth(map, i, j, z, 0));
                    possibles.add(fifth(map, i, j, z, 0));
                    possibles.add(fourth_two(map, i, j, z, 0));
                }
            }
        }
        System.out.println(Collections.max(possibles));
    }
}
