package src.com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_1859 {
	static int T;
	static int N;
	static int[] map;
	static int max;
	static int start;
	static long answer = 0;

	static int findmax(int index) {
		for (int i = index; i < N; i++) {
			if (map[i] > max) {
				index = i;
				max = map[i];
			}
		}
		max = map[index];
		return index;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++)
				map[i] = Integer.parseInt(st.nextToken());

			max = 0;
			answer = 0;
			for (int i = N - 1; i >= 0; i--) {
				if (max < map[i])
					max = map[i];
				else {
					int num = max - map[i];
					answer += num;
				}
			}

			System.out.println("#" + test + " " + answer);

		}
	}

}
