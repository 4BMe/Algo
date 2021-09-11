package kakao;

import java.util.StringTokenizer;

public class KAKAO4_2021 {

	static StringTokenizer st;
	static int n = 5;
	static int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
	static int[] res = new int[11];
	static int[] ans = new int[11];
	static int maxScore;
	static int minIdx;

	static void init() throws Exception {

	}

	static int[] solve() {

		dfs(0, 0);

		int[] w = { -1 };
		return maxScore == 0 ? w : ans;
	}

	static void dfs(int idx, int cnt) {
		if (cnt > n)
			return;
		if (idx == 11) {
			if (cnt != n)
				return;
			int Lscore = 0;
			int Pscore = 0;
			for (int i = 0; i < 11; i++) {
				if (info[i] == 0 && res[i] == 0)
					continue;
				if (info[i] >= res[i])
					Pscore += 10 - i;
				else
					Lscore += 10 - i;
			}

			if (Lscore <= Pscore || Lscore < maxScore)
				return;

			int min = 0;
			for (int i = 10; i >= 0; i--) {
				if (res[i] != 0) {
					min = i;
					break;
				}
			}

			if (Lscore > maxScore) {
				for (int i = 0; i < 11; i++)
					ans[i] = res[i];
				minIdx = min;
				maxScore = Lscore;
			} else {
				if (minIdx < min || (minIdx == min && res[min] > ans[min])) {
					for (int i = 0; i < 11; i++)
						ans[i] = res[i];
					minIdx = min;
					maxScore = Lscore;
				}
			}

			return;
		}
		for (int i = 0; i <= n - cnt; i++) {
			res[idx] = i;
			dfs(idx + 1, cnt + i);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
