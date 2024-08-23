import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<String> ary = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), 1); //듣도 못한 사람
        }

        for (int i = 0; i < m; i++) {
            String name= br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1); //이미 들어있으면 듣도보도못한사람 1+1
        }


        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value > 1){
                ary.add(key);
            }

        }

        Collections.sort(ary);


        sb.append(ary.size()).append('\n');
        for (String string : ary) {
            sb.append(string).append('\n');
        }


        System.out.println(sb);
        br.close();
    }

}