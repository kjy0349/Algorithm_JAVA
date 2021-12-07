package backjoon;
import java.util.*;
import java.io.*;

public class Stair_stepping {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> stairs = new ArrayList<>();
        boolean[] visited = new boolean[N];
        int answer = 0;
        ArrayList<Integer> possible = new ArrayList<>();
        for(int i=0;i<N;i++){
            stairs.add(Integer.parseInt(br.readLine()));
        }
        for(int i=3;i<N;i++){

        }
    }
}
