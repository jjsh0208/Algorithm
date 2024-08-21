import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n];
        int[] sorted = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < sorted.length; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int range = 0;

        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, range);
                range++;
            }
        }

        for (int i : origin) {
            sb.append(map.get(i)).append(' ');
        }
        

        System.out.println(sb);
        br.close();
    }
}