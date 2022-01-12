package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Programmers_외벽점검 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n = 50;
	static int[] weak = { 1, 2, 3, 4, 10, 11, 20, 21, 22, 30 };
	static int[] dist = { 1, 1, 2, 3 };
	static int ans = 9;
	static boolean[] dv;

	static int solution(int n, int[] weak, int[] dist) {
		dv = new boolean[dist.length];

		for (int j = 0, w = weak.length; j < w; j++) {
			Rdfs(j, dist.length - 1, 0, 0, new boolean[weak.length]);
			Ldfs(j, dist.length - 1, 0, 0, new boolean[weak.length]);
		}
		return ans == 9 ? -1 : ans;
	}

	static void Ldfs(int wIdx, int dIdx, int cnt, int res, boolean[] v) {
		int start = weak[wIdx];
		int end = start - dist[dIdx];
		int last = wIdx;
		boolean[] nv = Arrays.copyOf(v, v.length);
		for (int i = 0, c = weak.length; i < c; i++) {
			int idx = (c + wIdx - i) % c;
			if (nv[idx]) {
				continue;
			}
			int now = weak[idx];
			if ((end <= now && now <= start) || (0 > end && (now >= n + end || now <= start))) {
				nv[idx] = true;
				cnt++;
				last = idx;
			}
		}
		if (cnt == weak.length) {
			ans = Math.min(ans, res + 1);
			return;
		}
		dv[dIdx] = true;
		for (int i = dist.length - 1; i >= 0; i--) {
			if (dv[i]) {
				continue;
			}
			Ldfs((last - 1 + weak.length) % weak.length, i, cnt, res + 1, nv);
		}
		dv[dIdx] = false;
	}

	static void Rdfs(int wIdx, int dIdx, int cnt, int res, boolean[] v) {
		int start = weak[wIdx];
		int end = start + dist[dIdx];
		int last = wIdx;
		boolean[] nv = Arrays.copyOf(v, v.length);
		for (int i = 0, c = weak.length; i < c; i++) {
			int idx = (wIdx + i) % c;
			if (nv[idx]) {
				continue;
			}
			int now = weak[idx];
			if ((start <= now && now <= end) || (n <= end && (start <= now || now <= end % n))) {
				nv[idx] = true;
				cnt++;
				last = idx;
			}
		}

		if (cnt == weak.length) {
			ans = Math.min(ans, res + 1);
			return;
		}
		dv[dIdx] = true;
		for (int i = dist.length - 1; i >= 0; i--) {
			if (dv[i]) {
				continue;
			}
			Rdfs((last + 1) % weak.length, i, cnt, res + 1, nv);
		}
		dv[dIdx] = false;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(n, weak, dist));
	}

}