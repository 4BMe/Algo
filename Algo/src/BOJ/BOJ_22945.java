package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22945 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
	}

	static int solve() {
		int ans = 0;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int min = Math.min(num[start], num[end]);
			ans = Math.max((end - start - 1) * min, ans);
			if (num[start] < num[end]) {
				start++;
			} else {
				end--;
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		init();
		System.out.println(solve());
	}

}
