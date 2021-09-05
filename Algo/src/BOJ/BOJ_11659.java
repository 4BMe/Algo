package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11659 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] arr;
	static int[] sum;
	static List<int[]> list = new ArrayList<int[]>();

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		sum = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
	}

	static void solve() {
		int s = 0;
		for (int i = 0; i <= n; i++) {
			s += arr[i];
			sum[i] = s;
		}
		sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int cur[] = list.get(i);
			sb.append(sum[cur[1]] - sum[cur[0] - 1] + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
