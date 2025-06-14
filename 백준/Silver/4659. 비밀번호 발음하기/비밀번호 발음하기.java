import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static BufferedReader br;
	private static StringBuilder sb;
	private static String password;
	private static boolean flag;
	private static char prev;
	private static int count;

	private static String acc = "> is acceptable.\n";
	private static String not = "> is not acceptable.\n";

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();


		while(!(password = br.readLine()).equals("end")){

			flag = false;
			prev = '.';
			count = 0;

			for(char p : password.toCharArray()){

				if (isVowel(p)) flag = true;

				if (isVowel(p) == (isVowel(prev))) count++;
				else count = 1;

				if (count > 2 || (prev == p && (p != 'e' && p != 'o'))){
					flag = false;
					break;
				}

				prev = p;
			}

			if (flag) sb.append("<").append(password).append(acc);
			else sb.append("<").append(password).append(not);
		}

		System.out.println(sb);

		br.close();

	}

	private static boolean isVowel(char p){
		return p == 'a' || p == 'e' || p == 'i' || p == 'o' || p == 'u';
	}

}