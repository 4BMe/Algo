package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2533_x {
	static int N;
	static boolean[][] link;
	static boolean[] visited;
	static int[] lcnt;

	static void go() {

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		link = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		lcnt = new int[N + 1];

		int s, d;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			link[s][d] = true;
		}

//		int m = 0;
//		int idx = 0;
//		for (int i = 1; i <= N; i++)
//			if (lcnt[i] > m)
//				idx = i;

	}

}
