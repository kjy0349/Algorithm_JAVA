package backjoon;

import java.io.*;
public class Goldbach {
    static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        boolean[] checked = new boolean[MAX+1];
        checked[0] = checked[1] = true;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                break;
            } else{
                for(int i = 3;i < num; i++){
                    if(!checked[i]){
                        if(!checked[num - i]){
                            bw.write(String.format("%d = %d + %d\n", num, i, num - i));
                            break;
                        }
                    }
                }
            }
        }
        bw.flush();
    }
}