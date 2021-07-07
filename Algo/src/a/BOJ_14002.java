package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_14002 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] arr;
	static int[] dp;
	static Stack<Integer> stack = new Stack<>();
	static int ans = 1;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

	}

	static void solve() {
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ans = Math.max(ans, dp[i]);
				}
			}
		}

		System.out.println(ans);

		for (int i = n - 1; i >= 0; i--) {
			if (ans == dp[i]) {
				stack.push(arr[i]);
				ans--;
			}
		}

		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
