package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] board;
	static int ans;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n + 1][m + 1];
		ans = 0;
	}

	static void solve() {
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int idx) {
		if (idx == n * m) {
			ans++;
			return;
		}
		int y = idx / m + 1;
		int x = idx % m + 1;

		if (board[y - 1][x] == 1 && board[y][x - 1] == 1 && board[y - 1][x - 1] == 1) {
			dfs(idx + 1);
		} else {
			dfs(idx + 1); // 선택 안하고 다음껄 볼 경우
			board[y][x] = 1;
			dfs(idx + 1); // 선택 하고 다음껄 볼 경우
			board[y][x] = 0;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
