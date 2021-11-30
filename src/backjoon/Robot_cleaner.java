package backjoon;
import java.io.*;
import java.util.Arrays;

public class Robot_cleaner {
    public static boolean all_check(int x, int y, int[][] location){ // check가 true면 4방향 다 막혀있는것 or 청소됨
        boolean[] check_bool = new boolean[4];
        boolean check = true;
        for(int i=0;i<4;i++){
            if(check_foward(x, y, location, i)) check_bool[i] = true;
        }
        for(boolean ind : check_bool){
            if(!ind) check = false;
        }
        return check;
    }
    public static boolean left_clean_check(int x, int y, int[][] location, int direction){
        switch(direction){
            case 0:
                return location[x][y-1] == 0;
            case 1:
                return location[x-1][y] == 0;
            case 2:
                return location[x][y+1] == 0;
            case 3:
                return location[x+1][y] == 0;
            default:
                return false;
        }
    }
    public static boolean check_behind(int x, int y, int[][] location, int direction){
        switch(direction){
            case 0:
                if(location[x+1][y] == 0 || location[x+1][y] == 2) return true;
                break;
            case 1:
                if(location[x][y-1] == 0 || location[x][y-1] == 2) return true;
                break;
            case 2:
                if(location[x-1][y] == 0 || location[x-1][y] == 2) return true;
                break;
            case 3:
                if(location[x][y+1] == 0 || location[x][y+1] == 2) return true;
                break;
            default:
                return false;
        }
        return false;
    }
    public static boolean check_foward(int x, int y, int[][] location, int direction){
        switch(direction){ // 벽이거나 청소가 되어있으면 return true
            case 0:
                return location[x-1][y] == 1 || location[x-1][y] == 2;
            case 1:
                return location[x][y+1] == 1 || location[x][y+1] == 2;
            case 2:
                return location[x+1][y] == 1 || location[x+1][y] == 2;
            case 3:
                return location[x][y-1] == 1 || location[x][y-1] == 2;
            default:
                return false;
        }
    }
    public static int[] step(int x, int y, int direction){
        switch(direction){
            case 0:
                return new int[]{x-1, y};
            case 1:
                return new int[]{x, y+1};
            case 2:
                return new int[]{x+1, y};
            case 3:
                return new int[]{x, y-1};
            default:
                return new int[]{};
        }
    }
    public static int turn_left(int direction){
        if (direction == 0){
            return 3;
        } else{
            return direction - 1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String[] start_point = br.readLine().split(" ");
        int x = Integer.parseInt(start_point[0]);
        int y = Integer.parseInt(start_point[1]);
        int answer = 0;
        int direction = Integer.parseInt(start_point[2]);
        int temp_direction = 0;
        int[] temp;
        int[][] location = new int[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])];
        for(int i=0;i < Integer.parseInt(inputs[0]);i++){
            location[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        while(true){
            if(location[x][y] == 0){
                location[x][y] = 2;
                answer += 1;
            }
            while (true){
                if(all_check(x, y, location) && check_behind(x, y, location, direction)){
                    temp_direction = turn_left(direction);
                    temp_direction = turn_left(temp_direction);
                    temp = step(x, y, temp_direction);
                    x = temp[0];
                    y = temp[1];
                    continue;
                }
                if(all_check(x, y, location) && !check_behind(x, y, location, direction)){
                    System.out.println(answer);
                    return;
                }
                if(left_clean_check(x, y, location, direction)){
                    direction = turn_left(direction);
                    temp = step(x, y, direction);
                    x = temp[0];
                    y = temp[1];
                    break;
                } else{
                    direction = turn_left(direction);
                }
            }
        }
    }
}
