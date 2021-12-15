package backjoon;
import java.io.*;

public class Candy_Game {
    public static char[][] swap(char[][] map, int x, int y, int x1, int y1){
        char temp;
        temp = map[x][y];
        map[x][y] = map[x1][y1];
        map[x1][y1] = temp;
        return map;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        int answer = 0;
        int cnt;
        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(j+1 < N){
                    if(!(map[i][j] == map[i][j+1])){
                        swap(map, i, j, i, j+1);
                        for(int k=0;k<N;k++){
                            cnt = 1;
                            for(int l=1;l<N;l++){
                                if(map[k][l] == map[k][l-1]){
                                    cnt++;
                                    if(cnt > answer) answer = cnt;
                                }
                                else cnt = 1;
                            }
                        }
                        for(int k=0;k<N;k++){
                            cnt = 1;
                            for(int l=1;l<N;l++){
                                if(map[l][k] == map[l-1][k]){
                                    cnt++;
                                    if(cnt > answer) answer = cnt;
                                }
                                else cnt = 1;
                            }
                        }
                        swap(map, i, j, i, j+1);
                    }
                }
                if(i+1 < N){
                    if(!(map[i][j] == map[i+1][j])){
                        swap(map, i, j, i+1, j);
                        for(int k=0;k<N;k++){
                            cnt = 1;
                            for(int l=1;l<N;l++){
                                if(map[k][l] == map[k][l-1]){
                                    cnt++;
                                    if(cnt > answer) answer = cnt;
                                }
                                else cnt = 1;
                            }
                        }
                        for(int k=0;k<N;k++){
                            cnt = 1;
                            for(int l=1;l<N;l++){
                                if(map[l][k] == map[l-1][k]){
                                    cnt++;
                                    if(cnt > answer) answer = cnt;
                                }
                                else cnt = 1;
                            }
                        }
                        swap(map, i, j, i+1, j);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
