import java.util.*;
import java.io.*;

public class Main {

    static int[] dz = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dx = {0,0,0,0,-1,1};

    static int m,n,h;
    static int[][][] map;
    static int unripeCnt = 0;
    static Queue<Tomato> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이

        map = new int[h][n][m];

        for(int i = 0 ; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        queue.add(new Tomato(i,j,k));
                    }else if(map[i][j][k] == 0){
                        unripeCnt++;
                    }
                }
            }
        }

        if(unripeCnt == 0){
            System.out.println(0);
            return;
        }

        int days = bfs();


        System.out.println(unripeCnt == 0 ?  days : -1);
    }

    private static int bfs() {
        int days = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int s = 0; s < size; s++){
                Tomato tomato = queue.poll();

                for(int i = 0; i < 6; i++){
                    int newZ = tomato.z + dz[i];
                    int newY = tomato.y + dy[i];
                    int newX = tomato.x + dx[i];

                    if(isValid(newZ,newY,newX) && map[newZ][newY][newX] == 0){
                        map[newZ][newY][newX] = 1;
                        queue.add(new Tomato(newZ,newY,newX));
                        unripeCnt--;
                    }
                }
            }

            days++;
        }

        return days - 1;
    }

    private static boolean isValid(int z, int y, int x){
        return z >= 0 && z < h && y >= 0 && y < n && x >= 0 && x < m;
    }


    static class Tomato{
        int z;
        int y;
        int x;

        Tomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

}