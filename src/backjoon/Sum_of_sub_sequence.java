package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Sum_of_sub_sequence { // 조합
    private static int result = 0;
    public static void comb(int[] array, int answer, int N, int R,int S, int start){
        if(R == 0){
            if(answer == S){
                result += 1;
            }
        } else{
            for(int i = start; i<N;i++){
                    answer += array[i];
                    comb(array, answer, N, R-1, S, i + 1);
                    answer -= array[i];
            }
        }
    }
    public static int getResult(){
        return result;
    }

    public static void main(String[] args) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int S = Integer.parseInt(inputs[1]);
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=1;i<N+1;i++){
                comb(array, 0, N, i, S, 0);
            }
            System.out.println(getResult());

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
