package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Programmers_주식가격 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] prices = { 1, 2, 3, 2, 3 };

	static int[] solve(int[] prices) {
		int len = prices.length;
		int[] ans = new int[len];

		Stack<int[]> s = new Stack<int[]>();
		s.push(new int[] { prices[0], 0 });

		for (int i = 1; i < len; i++) {
			if (!s.isEmpty()) {
				int[] top = s.peek();
				if (prices[i] < top[0]) {
					while (!s.isEmpty() && s.peek()[0] > prices[i]) {
						top = s.pop();
						ans[top[1]] = i - top[1];
					}
				}
			}
			s.push(new int[] { prices[i], i });
		}
		while (!s.isEmpty()) {
			int[] top = s.pop();
			ans[top[1]] = len - top[1] - 1;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve(prices)) {
			System.out.print(a + " ");
		}
	}

}