package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int y, x;
	static int[][] map = new int[11][30];
	static int[][] used = new int[11][30];
	static int[][] memo = new int[9][1 << 24];

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < y; i++)
			for (int j = 0; j < (1 << x); j++)
				memo[y][x] = -1;
	}

	static void solve() {
		int ret = getMaxChipCnt(0);
		sb.append(ret + "\n");
	}

	static void setNemo(int dy, int dx, int val) {
		used[dy][dx] = used[dy][dx + 1] = used[dy + 1][dx] = used[dy + 1][dx + 1] = val;
		if (val == 1)
			used[dy][dx] = 2;
	}

	static boolean isClean(int dy, int dx) {
		if (dx >= x - 1)
			return false;
		if (used[dy][dx] + used[dy][dx + 1] + used[dy + 1][dx] + used[dy + 1][dx + 1] > 0)
			return false;
		if (map[dy][dx] + map[dy][dx + 1] + map[dy + 1][dx] + map[dy + 1][dx + 1] > 0)
			return false;
		return true;
	}

	static int getMaxChipCnt(int stage) {
		int dy = stage / x;
		int dx = stage % x;
		int max = 0;
		int state = 0;
		if (dy == y - 2 && dx == x - 1)
			return 0;

		//DP
		if (dx == x - 1) {
			state = getState(dy);
			if (memo[dy][state] != -1)
				return memo[dy][state];
		}

		// 네모 설치
		if (isClean(dy, dx)) {
			setNemo(dy, dx, 1);
			int ret = getMaxChipCnt(stage + 1) + 1;
			if (ret > max)
				max = ret;
			setNemo(dy, dx, 0);
		}

		int ret = getMaxChipCnt(stage + 1);
		if (ret > max)
			max = ret;

		//DP
		if (dx == x - 1)
			memo[dy][state] = max;

		return max;
	}

	private static int getState(int dy) {
		int sum = 0;
		for (int i = 0; i < x - 1; i++) {
			sum <<= 1;
			if (used[dy][i] == 2)
				sum |= 0x1;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
