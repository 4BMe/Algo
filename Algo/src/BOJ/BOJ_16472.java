package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16472 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int ans = 1;
	static String s;
	static int[] alpha = new int[26];

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		s = br.readLine();
	}

	static void solve() {
		int start, end;
		start = end = 0;
		int cnt = 0;

		char front = s.charAt(start);
		char back;
		alpha[front - 'a']++;
		cnt++;

		while (start < s.length() - 1 && end < s.length() - 1) {
			if (cnt <= n) {
				end++;
				back = s.charAt(end);
				if (alpha[back - 'a'] == 0)
					cnt++;
				alpha[back - 'a']++;
			} else if (cnt > n) {
				alpha[front - 'a']--;
				if (alpha[front - 'a'] == 0)
					cnt--;
				start++;
				front = s.charAt(start);
			}
			if (cnt <= n)
				ans = Math.max(ans, end - start + 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
