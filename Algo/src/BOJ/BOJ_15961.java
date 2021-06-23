package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, d, k, c;
	static int[] sh;
	static int[] eat;
	static int answer;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		sh = new int[n];
		for (int i = 0; i < n; i++) {
			sh[i] = Integer.parseInt(br.readLine());
		}

		eat = new int[d + 1];
		answer = 0;
	}

	static void solve() {

		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (eat[sh[i % n]] == 0)
				cnt++;
			eat[sh[i % n]]++;
		}
		answer = Math.max(answer, eat[c] == 0 ? cnt + 1 : cnt);

		for (int i = 0; i < n; i++) {
			eat[sh[i]]--;
			if (eat[sh[i]] == 0)
				cnt--;
			if (eat[sh[(i + k) % n]] == 0)
				cnt++;
			eat[sh[(i + k) % n]]++;
			answer = Math.max(answer, eat[c] == 0 ? cnt + 1 : cnt);
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
