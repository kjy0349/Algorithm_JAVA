package backjoon;
import java.util.*;
import java.io.*;

public class Stair_stepping {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stairs = new ArrayList<>();
        for(int i=0;i<N;i++){
            stairs.add(Integer.parseInt(br.readLine()));
        }
        ArrayList<Integer> road_sum = new ArrayList<>(){
                {
                    add(stairs.get(0));
                    add(stairs.get(0) + stairs.get(1));
                    add(Arrays.stream(new int[]{stairs.get(0) + stairs.get(2), stairs.get(1) + stairs.get(2)}).max().orElse(-1)); // 계단 2개를 밟았을 때 최대
                }
        };
        for(int i=3; i<stairs.size();i++){
            road_sum.add(Arrays.stream(new int[]{road_sum.get(i-3) + stairs.get(i) + stairs.get(i-1),
                    road_sum.get(i-2) + stairs.get(i)}).max().orElse(-1));
        }
        System.out.println(Collections.max(road_sum));
    }
}
