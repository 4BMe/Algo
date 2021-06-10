package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int T;
	static int n;
	static int[][] box;
	static boolean[] visited;
	static int[][][] dp;
	static int answer;
	
	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		box = new int[n][3];
		answer = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	static void solve() {

		sb.append(answer + "\n");
	}


	public static void main(String[] args) throws Exception {

		T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int test = 1; test <= T; test++) {
			sb.append("#" + test + " ");
			init();
			solve();
		}
		System.out.println(sb);
	}

}
