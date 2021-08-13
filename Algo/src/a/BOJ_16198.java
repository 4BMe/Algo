package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16198 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] energy;
	static int[][] dp;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		energy = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			energy[i] = Integer.parseInt(st.nextToken());
		}

	}

	static void solve() {
		
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
