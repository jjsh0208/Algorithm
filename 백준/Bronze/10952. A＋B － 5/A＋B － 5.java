import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	
		while(true){
			String[] strs = br.readLine().split(" ");
			int A = Integer.parseInt(strs[0]);
			int B = Integer.parseInt(strs[1]);
			
			
			if((A == 0)&&(B == 0)){
				break;
			}
			
			bw.write((A+B)+"\n");
		}
		
		
		br.close();
        
		bw.flush();
		bw.close();
	}
}