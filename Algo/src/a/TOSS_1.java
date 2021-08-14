package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TOSS_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void solve() {
		long orderAmount = 100;
		long taxFreeAmount = 0;
		long serviceFee = 0;
		long answer;
		long suplyAmount = orderAmount - serviceFee;
		double suplyValue = (suplyAmount + 0.1 * taxFreeAmount) / 1.1;
		answer = (long) Math.ceil((suplyValue - taxFreeAmount) * 0.1);
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		solve();
	}

}
