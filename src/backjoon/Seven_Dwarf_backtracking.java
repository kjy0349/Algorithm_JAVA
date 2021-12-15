package backjoon;
import java.io.*;
import java.util.*;
public class Seven_Dwarf_backtracking {
    public static ArrayList<Integer> answers = new ArrayList<>();
    public static boolean finished = false;
    public static void back_tracking(int[] heights, boolean[] picked, int R, int sum){
        if(R == 0){
            int sub_sum = 0;
            for(int i=0;i<picked.length;i++){
                if(picked[i]) sub_sum += heights[i];
            }
            if(sum - sub_sum == 100) {
                for(int i=0;i<picked.length;i++){
                    if(!picked[i]) answers.add(heights[i]);
                }
                Collections.sort(answers);
                for (Integer answer : answers) System.out.println(answer);
                finished = true;
            }
        } else{
            for(int i=0;i<picked.length;i++){
                if(!picked[i]){
                    picked[i] = true;
                    back_tracking(heights, picked, R-1, sum);
                    if(!finished) picked[i] = false;
                    else break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        for(int i=0;i<9;i++){
            heights[i] = Integer.parseInt(br.readLine());
        }
        boolean[] picked = new boolean[9];
        int R = 2;
        int sum = Arrays.stream(heights).sum();
        back_tracking(heights, picked, R, sum);
    }
}
