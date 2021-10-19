package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1749 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] arr;
	static long[][] psum;
	static int[] ch;
	static long ans = Long.MIN_VALUE;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		psum = new long[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				ans = Math.max(ans, arr[i][j]);
				sum += arr[i][j];
				psum[i][j] = sum;
			}
		}

		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				psum[i][j] += psum[i - 1][j];
			}
		}

	}

	static void solve() {
		ch = new int[2];
		for (int y1 = 0; y1 < n; y1++) {
			for (int x1 = 0; x1 < m; x1++) {
				for (int y2 = y1; y2 < n; y2++) {
					for (int x2 = x1; x2 < m; x2++) {
						ans = Math.max(ans, getSum(y1, x1, y2, x2));
					}
				}
			}
		}
		System.out.println(ans);
	}

	static long getSum(int y1, int x1, int y2, int x2) {
		long res = psum[y2][x2];
		long left = x1 == 0 ? 0 : psum[y2][x1 - 1];
		long up = y1 == 0 ? 0 : psum[y1 - 1][x2];
		long gyo = (x1 == 0 || y1 == 0) ? 0 : psum[y1 - 1][x1 - 1];
		return res - left - up + gyo;
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}