import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	static LinkedList<String> list;
	public static void main(String[] args) throws IOException {

		// 1. 화살표를 한 칸 아래로 내린다. (채널 i에서 i+1로)
		// 2. 화살표를 위로 한 칸 올린다. (채널 i에서 i-1로)
		// 3. 현재 선택한 채널을 한 칸 아래로 내린다. (채널 i와 i+1의 위치를 바꾼다. 화살표는 i+1을 가리키고 있는다)
		// 4. 현재 선택한 채널을 위로 한 칸 올린다. (채널 i와 i-1의 위치를 바꾼다. 화살표는 i-1을 가리키고 있다)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		 list= new LinkedList<>();

		for(int i = 0; i < n; i++){
			list.add(br.readLine());
		}

		int index = 0;

		while(!list.get(index).equals("KBS1")){
			sb.append(1);
			index++;
		}

		while(index > 0){
			swap(index, list.indexOf("KBS1"));
			sb.append(4);
			index--;
		}

		while(!list.get(index).equals("KBS2")){
			sb.append(1);
			index++;
		}

		while(index > 1){
			sb.append(4);
			index--;
		}

		System.out.println(sb);
		br.close();
	}

	static private void swap (int a, int b){
		String temp = list.get(a);
		list.set(a,list.get(b));
		list.set(b,temp);
	}

}