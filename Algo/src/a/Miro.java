package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Miro {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static char[][] map = new char[5][6];
	static int[][] memo = new int[5][6];
	static int ay, ax, by, bx;

	static void init() throws Exception {
		String s;
		for (int i = 1; i <= 4; i++) {
			s = br.readLine();
			for (int j = 1; j <= 5; j++) {
				map[i][j] = s.charAt(j-1);
				if (map[i][j] == 'A') {
					ay = i;
					ax = j;
				} else if (map[i][j] == 'B') {
					by = i;
					bx = j;
				}
			}
		}
	}

	static void solve() {
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 6; j++) {
				if (i == 0)
					memo[i][j] = 0;
				else if (j == 0)
					memo[i][j] = 0;
				else
					memo[i][j] = 100;
			}
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {
				memo[i][j] = getMin(i, j);
			}
		}
		int ret = Math.abs(memo[ay][ax] - memo[by][bx]);
		if (ret <= 20)
			System.out.println(ret);
		else
			System.out.println("impossible");
	}

	static int getMin(int i, int j) {
		int a, b, c, d;
		a = b = c = d = 100;
		if (0 < i + 1 && i + 1 < 4 && map[i][j] != '#')
			a = map[i + 1][j];
		if (0 < i - 1 && i - 1 < 4 && map[i][j] != '#')
			b = map[i - 1][j];
		if (0 < j + 1 && j + 1 < 5 && map[i][j] != '#')
			c = map[i][j + 1];
		if (0 < j - 1 && j - 1 < 5 && map[i][j] != '#')
			d = map[i][j - 1];
		return Math.min(Math.min(Math.min(a, b), c), d);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
