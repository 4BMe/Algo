package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Programmers_소수찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String numbers = "17";
	static boolean[] sosu = new boolean[9876544];
	static boolean[] choosed;
	static int len;
	static List<Integer> ans = new LinkedList<Integer>();

	static int solve() {
		Arrays.fill(sosu, true);
		sosu[0] = sosu[1] = false;
		for (int i = 2; i * i < 9876544; i++) {
			for (int j = i * i; j < 9876544; j += i) {
				sosu[j] = false;
			}
		}
		len = numbers.length();
		choosed = new boolean[len];
		dfs(0, 0);
		return ans.size();
	}

	static void dfs(int cnt, int sum) {

		if (sosu[sum]) {
			ans.add(sum);
			sosu[sum] = false;
		}
		if (cnt == len) {
			return;
		}
		for (int i = 0; i < len; i++) {
			if (choosed[i]) {
				continue;
			}
			choosed[i] = true;
			dfs(cnt + 1, sum * 10 + numbers.charAt(i) - '0');
			choosed[i] = false;
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve());
	}

}