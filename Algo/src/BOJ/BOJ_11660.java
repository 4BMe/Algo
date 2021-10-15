package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[][] arr;
	static int[][] sum;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			int add = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				add += arr[i][j];
				sum[i][j] = add;
			}
		}
		sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int res = 0;
			for (int j = y1; j <= y2; j++) {
				res += sum[j][x2] - (x1 == 0 ? 0 : sum[j][x1 - 1]);
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		init();
	}

}