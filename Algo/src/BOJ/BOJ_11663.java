package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11663 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;;
	static int n;
	static int m;
	static long[] dot;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dot = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			dot[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dot);
		sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = n - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (dot[mid] < min) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			int lindex = left;

			left = 0;
			right = n - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (dot[mid] <= max) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			int rindex = right + 1;
			sb.append(rindex - lindex + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		init();
	}

}
