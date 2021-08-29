package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1174 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static String[] dec;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		dec = new String[1000000];
		n--;
	}

	static void solve() {
		if (n > 1022) {
			System.out.println(-1);
		} else if (n < 10) {
			System.out.println(n);
		} else {
			Queue<Long> q = new LinkedList<>();
			int cnt = 0;
			for (int i = 1; i < 10; i++) {
				q.add(new Long(i));
				cnt++;
			}
			while (cnt < n) {
				long k = q.poll();
				long temp = k % 10;
				for (int i = 0; i < temp; i++) {
					q.add(k * 10 + i);
					cnt++;
					if (cnt == n) {
						System.out.println(k * 10 + i);
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
