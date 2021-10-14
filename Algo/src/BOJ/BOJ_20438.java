package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20438 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, k, q, m, s, e;
	static boolean[] sleep;
	static boolean[] visited;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] dp = new int[n + 3];
		for (int i = 3; i <= n + 2; i++) {
			dp[i] = i;
		}

		sleep = new boolean[n + 3];
		visited = new boolean[n + 3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			sleep[num] = true;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < q; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (sleep[num])
				continue;
			for (int j = num; j < n + 3; j += num) {
				if (sleep[j])
					continue;
				visited[j] = true;
			}
		}
		for (int i = 3; i <= n + 2; i++) {
			int unAttend = (!visited[i]) ? 1 : 0;// 출석 되지 않은 학생 수 dp에 계산
			dp[i] = dp[i - 1] + unAttend;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			System.out.println(dp[e] - dp[s - 1]); // 구간에 해당하는 출석이 되지 않은 학생 수 출력
		}
	}

	public static void main(String[] args) throws Exception {
		init();
	}

}