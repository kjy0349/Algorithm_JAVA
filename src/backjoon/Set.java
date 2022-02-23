package backjoon;

import java.io.*;

public class Set {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void calculate(String operand, int S, int value) throws IOException{
        if (operand.equals("add")) S |= (1 << value);
        else if (operand.equals("remove")) S &= ~(1 << value);
        else if (operand.equals("check")){
            if ((S & (1 << value)) == 0) bw.write("0" + "\n");
            else bw.write("1" + "\n");
        }
        else if (operand.equals("toggle")) S ^= (1 << value);
        else if (operand.equals("all")){
            S = 0;
            S = ~S;
        }
        else if (operand.equals("empty")) S = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] operand;
        int value = 0;
        int S = 0;
        for (int i = 0;i < N;i++){
            operand = br.readLine().split(" ");
            String r_operand = operand[0];
            if (!(r_operand.equals("all") || r_operand.equals("empty"))) value = Integer.parseInt(operand[1]);
            calculate(r_operand, S, value);
        }
        bw.flush();
    }
}
