package backjoon;
import java.io.*;
import java.util.Arrays;
public class Find_Prime_Che {
    static final int MAX = 1000;
    public static void main(String[] args) throws IOException{
        boolean[] checked = new boolean[MAX+1];
        checked[0] = true;
        checked[1] = true;
        for(int i = 2; i * i <= MAX;i++){
            if(!checked[i]){
                for(int j = i + i; j <= MAX;j += i){
                    if(!checked[j]) {
                        checked[j] = true;
                    }
                }
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int num : numbers) if (!checked[num]) answer += 1;
        System.out.println(answer);
    }
}
