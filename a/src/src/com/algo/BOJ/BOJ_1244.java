package src.com.algo.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	static int N;
	static boolean[] s;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		s = new boolean[N + 1];
		st = new StringTokenizer(in.readLine());

		for (int i = 1; i < N + 1; i++)
			if (st.nextToken().equals("1"))
				s[i] = true;
			else
				s[i] = false;
		int t = Integer.parseInt(in.readLine());

		int b, idx;
		for (int time = 0; time < t; time++) {
			st = new StringTokenizer(in.readLine());
			b = Integer.parseInt(st.nextToken());
			idx = Integer.parseInt(st.nextToken());
			if (b == 1) {
				for (int i = idx; i <= N; i += idx) {
					s[i] = !s[i];
				}
			} else if (b == 2) {
				for (int i = 0, c = Math.min(N - idx, idx - 1); i <= c; i++) {
					if (s[idx + i] == s[idx - i]) {
						s[idx + i] = s[idx - i] = !s[idx - i];
					} else
						break;
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (s[i])
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
			if(i%20==0)System.out.println();
		}

	}

}
