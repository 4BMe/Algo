package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class TOSS_3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void solve() {
		String amountText = "0";
		boolean answer = true;
		String pattern = "^[1-9]{1,3}(,\\d{3})*$";
		String pattern2 = "^[1-9][0-9]*$";

		answer = Pattern.matches(pattern, amountText) | Pattern.matches(pattern2, amountText) | amountText.equals("0");
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {

		solve();
	}

}
