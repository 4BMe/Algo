package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14889 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int half;
	static int[][] S;
	static ArrayList<Integer> team1, team2;
	static boolean[] choose;
	static int answer;

	static void init() throws Exception {
		N = Integer.parseInt(in.readLine());
		S = new int[N][N];
		half = N / 2;
		choose = new boolean[N];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void dfs(int idx, int cnt) {
		if (cnt + N - idx < half) {
			return;
		}
		if (cnt == half) {
			team1 = new ArrayList<>(half);
			team2 = new ArrayList<>(half);
			for (int i = 0; i < N; i++) {
				if (choose[i])
					team1.add(i);
				else
					team2.add(i);
			}

			int t1, t2;
			t1 = t2 = 0;
			for (int i = 0; i < half; i++) {
				int y = team1.get(i);
				for (int j = 0; j < half; j++) {
					if (i == j)
						continue;
					int x = team1.get(j);
					t1 += S[y][x];
				}
			}

			for (int i = 0; i < half; i++) {
				int y = team2.get(i);
				for (int j = 0; j < half; j++) {
					if (i == j)
						continue;
					int x = team2.get(j);
					t2 += S[y][x];
				}
			}

			answer = Math.min(answer, Math.abs(t1 - t2));
			return;
		}
		for (int i = idx; i < N; i++) {
			choose[i] = true;
			dfs(i + 1, cnt + 1);
			choose[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		for (int i = 0; i < half; i++) {
			dfs(i,0);
		}
		System.out.println(answer);
	}

}
