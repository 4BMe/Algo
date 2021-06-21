package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Juwol {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] ch;
	static int sum = 0;
	static boolean[][] memo = new boolean[30][300001];

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		ch = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ch[i] = Integer.parseInt(st.nextToken());
			sum += ch[i];
		}
	}

	static void solve() {
		dfs(0, 0);
		int cnt=0;
		for (int i = 1; i <= 300000; i++) {
			if (memo[n][i])
				cnt++;
		}
		System.out.println(cnt);
		for (int i = 1; i <= 300000; i++) {
			if (memo[n][i])
				System.out.print(i + " ");
		}
	}

	static void dfs(int idx, int weightSum) {
		if (weightSum > 0) {
			if (memo[idx][weightSum])
				return;
			memo[idx][weightSum] = true;
		}
		if (idx == n)
			return;
		dfs(idx + 1, weightSum + ch[idx]);
		dfs(idx + 1, weightSum);
		dfs(idx + 1, weightSum - ch[idx]);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
