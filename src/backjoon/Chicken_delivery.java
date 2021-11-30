package backjoon;
import java.util.*;
import java.io.*;
public class Chicken_delivery {
    public static ArrayList<ArrayList<int[]>> possible = new ArrayList<>();
    public static void comb(ArrayList<int[]> chic_cord, ArrayList<int[]> answer, int N, int R, int start, boolean[] visited){
        if(R == 0){
            ArrayList<int[]> add_ans = new ArrayList<>(answer);
            possible.add(add_ans);
        } else{
            for(int i=start;i<N;i++){
                if(!visited[i]){
                    visited[i] = true;
                    answer.add(chic_cord.get(i));
                    comb(chic_cord, answer, N, R-1, i + 1, visited);
                    answer.remove(chic_cord.get(i));
                    visited[i] = false;
                }
            }
        }
    }
    public static int calculate(int[] home, int[] chicken){
        return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] city = new int[inputs[0]][inputs[0]];
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> answers = new ArrayList<>();
        ArrayList<int[]> chic_cord = new ArrayList<>();
        ArrayList<int[]> home_cord = new ArrayList<>();
        int chic_count = 0;
        int home_count = 0;
        ArrayList<int[]> answer = new ArrayList<>();
        for(int i=0;i<inputs[0];i++){
            city[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0;i<city.length;i++){
            for(int j=0;j<city[i].length;j++){
                if(city[i][j] == 2){
                    chic_count += 1;
                    chic_cord.add(new int[]{i,j});
                } else if(city[i][j] == 1){
                    home_count += 1;
                    home_cord.add(new int[]{i,j});
                }
            }
        }
        boolean[] visited = new boolean[chic_count];
        comb(chic_cord, answer, chic_count, inputs[1], 0, visited);
        int temp;
        for(int i=0;i<possible.size();i++){
            temp = 0;
            for(int j=0;j<home_count;j++){
                distances.clear();
                for(int k=0;k<possible.get(i).size();k++){
                    distances.add(calculate(home_cord.get(j), possible.get(i).get(k)));
                }
                temp += Collections.min(distances);
            }
            answers.add(temp);
        }
        System.out.println(Collections.min(answers));
    }
}
