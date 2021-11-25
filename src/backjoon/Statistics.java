package backjoon;
import java.util.*;
import java.io.*;

public class Statistics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        ArrayList<Integer> compare = new ArrayList<>();
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!counts.containsKey(array[i])){
                counts.put(array[i], 1);
            } else{
                counts.put(array[i], counts.get(array[i]) + 1);
            }
        }
        int max = Collections.max(counts.values());
        int max_count = 0;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(entry.getValue() == max){
                compare.add(entry.getKey());
                max_count++;
            }
        }
        Collections.sort(compare);
        Arrays.sort(array);
        System.out.printf("%.0f\n",Arrays.stream(array).average().orElse(-1));
        if(N == 1){
            System.out.println(array[0]);
        } else{
            System.out.println(array[N/2]);
        }
        if(max_count == 1){
            System.out.println(compare.get(0));
        } else{
            System.out.println(compare.get(1));
        }
        System.out.println(Arrays.stream(array).max().orElse(-1)- Arrays.stream(array).min().orElse(-1));
    }
}
