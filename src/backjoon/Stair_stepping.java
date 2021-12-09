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
        if(N >= 3){
            ArrayList<Integer> road_sum = new ArrayList<>(){
                    {
                        add(stairs.get(0));
                        add(stairs.get(0) + stairs.get(1));
                        add(Math.max(stairs.get(0) + stairs.get(2), stairs.get(1) + stairs.get(2))); // 계단 2개를 밟았을 때 최대
                    }
            };
            for(int i=3; i<stairs.size();i++){
                road_sum.add(Math.max(
                        road_sum.get(i-2) + stairs.get(i),
                        road_sum.get(i-3) + stairs.get(i) + stairs.get(i-1)));
            }
            System.out.println(road_sum.get(N-1));
        }else{
            System.out.println(stairs.stream().mapToInt(Integer::intValue).sum());
        }
    }
}