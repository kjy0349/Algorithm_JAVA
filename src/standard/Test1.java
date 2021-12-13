import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;
        String[] inputs;
        boolean isChecked = false;
        int u_index = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        int answer = 0;
        for(int i=1;i<T+1;i++){
            N = Integer.parseInt(br.readLine());
            inputs = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                numbers.add(Integer.parseInt(inputs[j]));
            }
            Collections.sort(numbers);
            for(int j=N-1;j>N/2-2;j--){
                isChecked = false;
                for(int k=0;k<j;k++){
                    if((numbers.get(j) + numbers.get(k)) % 2 == 0 && numbers.get(k) != 0){
                        answer += numbers.get(j);
                        numbers.set(k, 0);
                        isChecked = true;
                        break;
                    }
                }
                if(!isChecked && numbers.get(j) != 0){
                    u_index = j;
                }
            }
            if(u_index != 0){
                for(int j=0;j<u_index;j++){
                    if(numbers.get(j) != 0){
                        if((numbers.get(j) + numbers.get(u_index)) % 2 == 0){
                            answer += numbers.get(u_index);
                            break;
                        }
                        else {
                            answer += numbers.get(j);
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + i + " "+ answer);
            numbers.clear();
            u_index = 0;
            answer = 0;
        }
    }
}