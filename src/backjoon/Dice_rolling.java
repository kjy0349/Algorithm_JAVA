package backjoon;
import java.util.*;
import java.io.*;

public class Dice_rolling {
    public static int[] dice_rolling(int[] dice_info, int direction){
        int[] temp = dice_info.clone();
        switch(direction){
            case 1:
                dice_info[3] = temp[5];
                dice_info[0] = temp[3];
                dice_info[2] = temp[0];
                dice_info[5] = temp[2];
                break;
            case 2:
                dice_info[0] = temp[2];
                dice_info[3] = temp[0];
                dice_info[2] = temp[5];
                dice_info[5] = temp[3];
                break;
            case 3:
                dice_info[1] = temp[0];
                dice_info[0] = temp[4];
                dice_info[4] = temp[5];
                dice_info[5] = temp[1];
                break;
            case 4:
                dice_info[1] = temp[5];
                dice_info[0] = temp[1];
                dice_info[4] = temp[0];
                dice_info[5] = temp[4];
                break;
            default:
                break;
        }
        return dice_info;
    }

    public static void step(int[][] map, int[] cord, int direction, int[] dice_info){
        switch(direction){
            case 1:
                if(map[cord[0]].length > cord[1]+1){
                    cord[1] += 1;
                    dice_rolling(dice_info, direction);
                    if(map[cord[0]][cord[1]] == 0) map[cord[0]][cord[1]] = dice_info[5];
                    else {
                        dice_info[5] = map[cord[0]][cord[1]];
                        map[cord[0]][cord[1]] = 0;
                    }
                    System.out.println(dice_info[0]);
                }
                break;
            case 4:
                if(map.length > cord[0]+1){
                    cord[0] += 1;
                    dice_rolling(dice_info, direction);
                    if(map[cord[0]][cord[1]] == 0) map[cord[0]][cord[1]] = dice_info[5];
                    else {
                        dice_info[5] = map[cord[0]][cord[1]];
                        map[cord[0]][cord[1]] = 0;
                    }
                    System.out.println(dice_info[0]);
                }
                break;
            case 2:
                if(cord[1]-1 >= 0){
                    cord[1] -= 1;
                    dice_rolling(dice_info, direction);
                    if(map[cord[0]][cord[1]] == 0) map[cord[0]][cord[1]] = dice_info[5];
                    else {
                        dice_info[5] = map[cord[0]][cord[1]];
                        map[cord[0]][cord[1]] = 0;
                    }
                    System.out.println(dice_info[0]);
                }
                break;
            case 3:
                if(cord[0]-1 >= 0){
                    cord[0] -= 1;
                    dice_rolling(dice_info, direction);
                    if(map[cord[0]][cord[1]] == 0) map[cord[0]][cord[1]] = dice_info[5];
                    else {
                        dice_info[5] = map[cord[0]][cord[1]];
                        map[cord[0]][cord[1]] = 0;
                    }
                    System.out.println(dice_info[0]);
                }
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[1];
        int[] cord = new int[]{inputs[2], inputs[3]};
        int epochs = inputs[4];
        int[] operations;
        int[][] map = new int[N][M];
        int[] dice_info = new int[6];
        for(int i=0;i<N;i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        operations = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<epochs;i++){
            step(map, cord, operations[i], dice_info);
        }
    }
}
