import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashMap<Integer,Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            Integer o = Integer.parseInt(st.nextToken());
           map.put(o, 1);
        }

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < m; i++) {
             Integer o = Integer.parseInt(st.nextToken());
            if (map.containsKey(o)) {
                map.put(o, 0);
            } else {
                map.put(o, map.getOrDefault(o, 1));
            }
        }


        int cnt = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
        }
       
        System.out.println(cnt);
        br.close();
    }

}