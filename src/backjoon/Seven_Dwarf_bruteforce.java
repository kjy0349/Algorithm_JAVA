package backjoon;
import java.util.*;
import java.io.*;
public class Seven_Dwarf_bruteforce {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for(int i=0;i<heights.length;i++){
            heights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(heights);
        int sum = Arrays.stream(heights).sum();
        int first; int second;
        first = second = 0;
        boolean finished = false;
        for(int i=0;i<heights.length;i++){
            first = heights[i];
            for(int j=i+1;j<heights.length;j++){
                second = heights[j];
                if(sum - first - second == 100){
                    finished = true;
                    break;
                }
            }
            if(finished) break;
        }
        for(int height : heights){
            if(height != first && height != second) System.out.println(height);
        }
    }
}
