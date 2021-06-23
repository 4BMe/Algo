package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[9][9];
	static boolean[][][] check = new boolean[3][9][10];
	static int cnt = 0;

	static void init() throws Exception {
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				/* 네모 가로 세로 */
				check[0][find_area(i, j)][map[i][j]] = true;
				check[1][i][map[i][j]] = true;
				check[2][j][map[i][j]] = true;
				if (map[i][j] == 0)
					cnt++;
			}
		}
	}

	static int find_area(int y, int x) {

		y /= 3;
		x /= 3;

		return y * 3 + x;
	}

	static void solve() {
		go(0);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

	static void go(int idx) {
		if (cnt == 0)
			return;
		if (idx > 81)
			return;
		for (int i = idx; i < 81; i++) {
			if (map[i / 9][i % 9] != 0)
				continue;
			for (int j = 1; j < 10; j++) {
				if (check[0][find_area(i / 9, i % 9)][j])
					continue;
				if (check[1][i / 9][j])
					continue;
				if (check[2][i % 9][j])
					continue;
				cnt--;
				check[0][find_area(i / 9, i % 9)][j] = check[1][i / 9][j] = check[2][i % 9][j] = true;
				map[i / 9][i % 9] = j;
				go(idx + 1);
				if (cnt == 0)
					return;
				cnt++;
				check[0][find_area(i / 9, i % 9)][j] = check[1][i / 9][j] = check[2][i % 9][j] = false;
				map[i / 9][i % 9] = 0;
			}
			break;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
