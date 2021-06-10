package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class point {
	int y, x;

	point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class solution2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int y, x;
	static int[][] map;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[y][x];

		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < x; j++)
				map[i][j] = Integer.parseInt(br.readLine());
		}
	}

	static void solve() {
		List<point[]> poss = new ArrayList<point[]>();
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (i + 1 < y && j + 1 < x) {
					if (map[i][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j] == 0 && map[i + 1][j + 1] == 0)
						poss.add(new point[] { new point(i, j), new point(i, j + 1), new point(i + 1, j),
								new point(i + 1, j + 1) });
				}
			}
		}
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
