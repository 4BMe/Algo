package kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class KAKAO2_2021 {

	static StringTokenizer st;
	static StringBuilder sb;

	static void solve() {
		int n = 437674;
		int k = 3;
		String change = "";

		while (n > 0) {
			int mok = n / k;
			int na = n % k;
			change = na + change;
			n = mok;
		}

		change = 0 + change + 0;
		System.out.println(change);
		List<Integer> zero = new ArrayList<Integer>();
		for (int i = 0, w = change.length(); i < w; i++)
			if (change.charAt(i) == '0')
				zero.add(i);

		int ans = 0;
		for (int i = 0, c = zero.size(); i < c - 1; i++) {
			int start = zero.get(i);
			int end = zero.get(i + 1);
			if (start >= end)
				continue;
			String s = change.substring(start, end);
			if (isPrime(Long.parseLong(s)))
				ans++;
		}

		System.out.println(ans == 0 ? 0 : ans);
	}

	public static boolean isPrime(long num) {
		if (num <= 1)
			return false;
		for (long i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
