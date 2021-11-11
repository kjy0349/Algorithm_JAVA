package Programmers;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Conference_room_allocation {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        ArrayList<List<Integer>> conferences = new ArrayList<>();
        try{
            int N = Integer.parseInt(br.readLine());
            for (int i=0; i<N; i++){
                conferences.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
//        Arrays.sort(conferences, Comparator.comparingInt(o1 -> o1[0]));
    }
}
