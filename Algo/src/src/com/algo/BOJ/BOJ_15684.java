package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15684 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, h;
	static boolean[][] map;
	static int ans = Integer.MAX_VALUE;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new boolean[h + 1][n];

		int y, x;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken()) - 1;
			x = Integer.parseInt(st.nextToken()) - 1;
			map[y][x] = true;
		}
	}

	static void solve() {
		if (m == 0) {
			System.out.println(0);
			return;
		}

		go(-1, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	static void go(int idx, int b) {
		if (b > 3 || b > ans)
			return;

		for (int i = 0; i < n; i++) {
			if (dfs(i) != i)
				break;
			if (i == n - 1)
				ans = Math.min(ans, b);
		}

		int y, x;
		for (int i = idx + 1; i < n * h; i++) {
			y = i / n;
			x = i % n;
			if (!map[y][x]) {
				if ((x < n - 1 && map[y][x + 1]) || (x > 0 && map[y][x - 1]))
					continue;
				map[y][x] = true;
				go(i, b + 1);
				map[y][x % n] = false;
			}
		}

	}

	static int dfs(int x) {
		int y = 0;

		while (y < h) {
			if (x < n - 1 && map[y][x])
				x++;
			else if (0 < x && map[y][x - 1])
				x--;
			y++;
		}
		return x;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();

	}

}
