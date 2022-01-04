package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Programmers_N_Queen {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 12;
	static boolean[] vy;
	static boolean[] vx;
	static boolean[] vdl;
	static boolean[] vdr;
	static int ans = 0;

	static int solution(int n) {
		vy = new boolean[n];
		vx = new boolean[n];
		vdl = new boolean[n * 2 - 1];
		vdr = new boolean[n * 2 - 1];

		for (int i = 0; i < n; i++) {
			int y = 0;
			vy[y] = true;
			vx[i] = true;
			vdl[y - i + n - 1] = true;
			vdr[y + i] = true;
			drop(1, 1);
			vy[y] = false;
			vx[i] = false;
			vdl[y - i + n - 1] = false;
			vdr[y + i] = false;
		}

		return ans;
	}

	static void drop(int idx, int cnt) {
		if (cnt == n) {
			ans++;
			return;
		}
		if (idx == n * n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			int y = idx;
			int x = i;
			if (!vy[y] && !vx[x] && !vdl[y - x + n - 1] && !vdr[y + x]) {
				vy[y] = true;
				vx[x] = true;
				vdl[y - x + n - 1] = true;
				vdr[y + x] = true;
				drop(idx + 1, cnt + 1);
				vy[y] = false;
				vx[x] = false;
				vdl[y - x + n - 1] = false;
				vdr[y + x] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n));
	}

}