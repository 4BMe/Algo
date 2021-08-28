package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17136 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] board;
	static int pcnt = 0;
	static int ans;
	static int[] paper;

	static void init() throws Exception {
		board = new int[10][10];
		paper = new int[6];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					pcnt++;
			}
		}
		Arrays.fill(paper, 5);
		ans = Integer.MAX_VALUE;
	}

	static void solve() {
		dfs(0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void dfs(int idx, int cnt) {
		if (idx == 100) {
			if (pcnt == 0)
				ans = Math.min(ans, cnt);
			return;
		}
		int y = idx / 10;
		int x = idx % 10;
		if (board[y][x] == 0) {
			dfs(idx + 1, cnt);
		} else {
			for (int z = 5; z > 0; z--) {
				if (!poss(y, x, z) || paper[z] == 0)
					continue;
				cover(y, x, z, 0);
				pcnt -= z * z;
				paper[z]--;
				dfs(idx + 1, cnt + 1);
				cover(y, x, z, 1);
				pcnt += z * z;
				paper[z]++;
			}
		}

	}

	static boolean poss(int y, int x, int size) {
		if (y + size > 10 || x + size > 10)
			return false;
		for (int i = y, c = y + size; i < c; i++) {
			for (int j = x, w = x + size; j < w; j++) {
				if (board[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	static void cover(int y, int x, int size, int num) {
		for (int i = y, c = y + size; i < c; i++) {
			for (int j = x, w = x + size; j < w; j++) {
				board[i][j] = num;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
