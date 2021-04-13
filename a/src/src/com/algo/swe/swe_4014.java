package src.com.algo.swe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swe_4014 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	static int n, x;
	static int[][] map;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	}

	static void solve() {
		int answer = 0;
		answer += rowCheck();
		answer += colCheck();
		sb.append(answer + "\n");
	}

	static int rowCheck() {
		int cnt = 0;

		int before;
		int con, need, comp;
		boolean poss;

		for (int i = 0; i < n; i++) {
			before = map[i][0];
			con = 1;
			need = 0;
			poss = true;
			for (int j = 1; j < n; j++) {
				comp = before - map[i][j];
				if (comp == 0) {
					con++;
				} else if (Math.abs(comp) == 1) {
					if (need != 0) {
						if (con < need) {
							poss = false;
							break;
						}
						con -= need;
						need = 0;
					}
					if (comp == 1) {
						need = x;
					} else if (comp == -1) {
						if (con < x) {
							poss = false;
							break;
						}
					}
					con = 1;
				} else {
					poss = false;
					break;
				}
				before = map[i][j];
			}
			if (con - need < 0) {
				poss = false;
			}
			if (poss)
				cnt++;
		}

		return cnt;
	}

	static int colCheck() {
		int cnt = 0;

		int before;
		int con, need, comp;
		boolean poss;

		for (int i = 0; i < n; i++) {
			before = map[0][i];
			con = 1;
			need = 0;
			poss = true;
			for (int j = 1; j < n; j++) {
				comp = before - map[j][i];
				if (comp == 0) {
					con++;
				} else if (Math.abs(comp) == 1) {
					if (need != 0) {
						if (con < need) {
							poss = false;
							break;
						}
						con -= need;
						need = 0;
					}
					if (comp == 1) {
						need = x;
					} else if (comp == -1) {
						if (con < x) {
							poss = false;
							break;
						}
					}
					con = 1;
				} else {
					poss = false;
					break;
				}
				before = map[j][i];
			}
			if (con - need < 0) {
				poss = false;
			}
			if (poss)
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {

		t = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= t; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
