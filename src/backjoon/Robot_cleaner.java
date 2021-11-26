package backjoon;
import java.io.*;
import java.util.Arrays;

public class Robot_cleaner {
    public void left_check(int[][] array, int x, int y, int direction){

    }
    public void get_back(int[][] array, int x, int y, int direction){

    }
    public void stop(int[][] array, int x, int y, int direction){

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String[] start_point = br.readLine().split(" ");
        int x = Integer.parseInt(start_point[0]);
        int y = Integer.parseInt(start_point[1]);
        int[][] location = new int[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])];
        for(int i=0;i < location.length;i++){
            location[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        while(true){

        }
    }
}
