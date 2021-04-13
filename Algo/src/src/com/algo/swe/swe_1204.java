package src.com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_1204 {
	static int T;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			in.readLine();
			map = new int[101];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < 1000; i++)
				map[Integer.parseInt(st.nextToken())]++;

			int answer = 0;
			int cnt = 0;
			for (int i = 1; i <= 100; i++)
				if (map[i] >= cnt) {
					cnt = map[i];
					answer = i;
				}

			System.out.println("#" + test + " " + answer);

		}
	}

}
