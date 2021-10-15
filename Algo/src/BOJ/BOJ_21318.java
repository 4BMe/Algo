package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21318 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] ac;
	static int[] miss;
	static int q;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		ac = new int[n];
		miss = new int[n];

		st = new StringTokenizer(br.readLine());
		int sum = 0;
		ac[0] = Integer.parseInt(st.nextToken());
		int now = ac[0];
		int before = now;
		for (int i = 1; i < n; i++) {
			ac[i] = Integer.parseInt(st.nextToken());
			now = ac[i];
			if (now < before)
				sum++;
			miss[i] = sum;
			before = now;
		}

		sb = new StringBuilder();
		q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int res = miss[to] - miss[from];
//			- ac[from] > ac[to] ? 0 : 1
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}

	static void solve() {
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}