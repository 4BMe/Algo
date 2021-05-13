package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1016 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static long min, max;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
	}

	static void solve() {
		boolean[] ch = new boolean[(int) (max - min + 1)];

		for (long i = 2; i * i <= max; i++) {
			long p = i * i;
			long start = min % p == 0 ? min / p : (min / p) + 1;
			for (long j = start; p * j <= max; j++) {
				ch[(int) ((j * p) - min)] = true;
			}
		}
		
		int answer = 0;
		for (int i = 0; i <= max - min; i++) {
			if (!ch[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
