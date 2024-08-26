import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main{
  
    static List<int[]> steps;

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        steps = new ArrayList();

        int n = Integer.parseInt(br.readLine());

        BigInteger count = new BigInteger("2");
        System.out.println(count.pow(n).subtract(new BigInteger("1")));

        if (n <= 20) {
            hanoi(n , 1, 2, 3);
            for (int i = 0; i < steps.size(); i++) {
                int[] ary = steps.get(i);
                System.out.println(ary[0] + " " + ary[1]);
            }
        }
    }

    private static void hanoi(int n, int from, int to, int tartget) {
        if (n == 1) { //1 -> 3;
            steps.add(new int [] {from, tartget});
        }else{
            hanoi(n -1, from, tartget, to); // 1 -> 2;
            steps.add(new int [] {from , tartget});
            hanoi(n - 1, to, from, tartget); // 2 -> 3;
        }
    }
}