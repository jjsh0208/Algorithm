import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	private static StringTokenizer st;
	private static BufferedReader br;
	private static int n , k;
	private static ArrayList<Country> list = new ArrayList<>();
	private static int endPoint = 0;

	static class Country implements Comparable<Country> {
		int number;
		int gold;
		int silver;
		int bronze;
		int rank;

		public Country(int number, int gold, int silver, int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this. rank = 0;
		}

		public boolean equalsMedals(int gold, int silver, int bronze) {
			return this.gold == gold &&
				this.silver == silver &&
				this.bronze == bronze;
		}

		@Override
		public int compareTo(Country o) {
			if (this.gold != o.gold)
				return o.gold - this.gold;
			if (this.silver != o.silver)
				return o.silver - this.silver;
			return o.bronze - this.bronze;
		}
	}

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i ++){
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			list.add(new Country(number,gold,silver,bronze));
		}

		Collections.sort(list);
		list.get(0).rank = 1;

		for (int i = 1; i < list.size(); i++){
			Country now = list.get(i);

			int preG = list.get(i - 1).gold;
			int preS = list.get(i - 1).silver;
			int perB = list.get(i - 1).bronze;

			if (list.get(i).number == k){
				endPoint = i;
			}

			if (now.equalsMedals(preG,preS, perB)){
				list.get(i).rank = list.get(i - 1).rank;
			}
			else{
				list.get(i).rank = i + 1;
			}
		}

		System.out.println(list.get(endPoint).rank);

		br.close();
	}

}