package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20442 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String s;
	static int ans = 0;

	static void init() throws Exception {
		s = br.readLine();
	}

	static void solve() {
		List<Integer> lk = new ArrayList<Integer>();
		List<Integer> rk = new ArrayList<Integer>();
		int n = s.length();

		int kcnt = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'K')
				kcnt++;
			else
				lk.add(kcnt);
		}
		kcnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == 'K')
				kcnt++;
			else
				rk.add(kcnt);
		}
		rk.sort(Comparator.reverseOrder());

		int left = 0;
		int right = rk.size() - 1;
		ans = 0;
		while (left <= right) {
			ans = Math.max(ans, (right - left + 1) + (2 * Math.min(lk.get(left), rk.get(right))));
			if (lk.get(left) < rk.get(right)) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
