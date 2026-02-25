import java.io.*;

public class Main {

    static int n;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 2, 3, 5, 7
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    private static void DFS(int num, int jarisu) {
        if(jarisu == n){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }

        for(int i = 1; i < 10; i++){
            if(i % 2 == 0) continue;
            if(isPrime((num * 10) + i)){
                DFS((num * 10) + i , jarisu + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i <= num / 2; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
