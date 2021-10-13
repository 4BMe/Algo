package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m, k;
	static int[][] arr;
	static int[][] sum;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		sum = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = 0;
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				s += arr[i][j];
				sum[i][j] = s;
			}
		}

		sb = new StringBuilder();
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			sb.append(solve(sy, sx, ey, ex) + "\n");
		}
		System.out.println(sb);
	}

	static int solve(int sy, int sx, int ey, int ex) {
		int res = 0;

		for (int i = sy; i <= ey; i++) {
			res += sum[i][ex] - sum[i][sx] + arr[i][sx];
		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		init();
	}

}