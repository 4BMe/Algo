package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, S;
	static int[] num;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		int fp = 0, sp = 0;
		int sum = 0, answer = Integer.MAX_VALUE;

		while (fp <= N && sp <= N) {
			if (sum >= S)
				answer = Math.min(answer, sp - fp);
			if (sum < S)
				sum += num[sp++];
			else
				sum -= num[fp++];
		}
		System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
