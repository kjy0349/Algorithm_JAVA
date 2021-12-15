package backjoon;
import java.io.*;
import java.util.Arrays;
public class Remote_Controller {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] buttons = new boolean[10];
        int answer = Math.abs(N - 100);
        int M = Integer.parseInt(br.readLine());
        if(M == 0){
            if(N > 97 && N < 103) System.out.println(answer);
            else System.out.println(Integer.toString(N).length());
        }
        else{
            int length;
            int[] button = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0;i<M;i++){
                buttons[button[i]] = true;
            }
            boolean checked;
            for(int i=0;i<1000000;i++){
                checked = false;
                char[] array = Integer.toString(i).toCharArray();
                for (char c : array)
                    if (buttons[c - '0']) {
                        checked = true;
                        break;
                    }
                if(checked) continue;
                length = Integer.toString(i).length();
                int compare = length + Math.abs(N - i);
                if(compare < answer) answer = compare;
            }
            System.out.println(answer);
        }
    }
}
