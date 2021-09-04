package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static int[] arr1;
	static int[] arr2;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr1 = new int[n];
		arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}

	}

	static void solve() {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		sb = new StringBuilder();
		int i = 0, j = 0;
		while (true) {
			if (i == n && j == m) {
				System.out.println(sb);
				return;
			} else if (i == n) {
				sb.append(arr2[j] + " ");
				j++;
			} else if (j == m) {
				sb.append(arr1[i] + " ");
				i++;
			} else {
				int a, b;
				a = arr1[i];
				b = arr2[j];
				if (a <= b) {
					sb.append(a + " ");
					i++;
				} else {
					sb.append(b + " ");
					j++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
