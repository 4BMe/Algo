package kaokaopay;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KP1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void init() throws Exception {
		int[] prices = { 13000, 88000, 10000 };
		int[] discounts = { 30, 20 };
		Arrays.sort(prices);
		Arrays.sort(discounts);
		int plen = prices.length;
		int dlen = discounts.length;
		for (int i = dlen - 1; i >= 0; i--) {
			if (plen - (dlen - i) < 0)
				break;
			prices[plen - (dlen - i)] *= (100 - discounts[i]);
			prices[plen - (dlen - i)] /=100;
		}
		int ans = 0;
		for (int price : prices) {
			ans += price;
		}
		System.out.println(ans);
	}

	static void solve() {
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
