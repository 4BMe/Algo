package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static int N;
	static int[] p;
	static boolean[] checked;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		p = new int[N];
		checked = new boolean[N];
		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		int d;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0, c = Integer.parseInt(st.nextToken()); j < c; j++) {
				d = Integer.parseInt(st.nextToken());
				adj[i].add(d);
			}
		}
		
	}

}
