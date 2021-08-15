package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16198 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static List<Integer> energy;
	static int[] dp;
	static int ans;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		energy = new LinkedList();
		dp = new int[1 << (n + 1)];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			energy.add(Integer.parseInt(st.nextToken()));
		}

		ans = 0;
	}

	static void solve() {
		for (int i = 1, c = energy.size(); i < c - 1; i++) {
			List<Integer> temp = copy(energy);
			dfs(temp, i, 0);
		}
		System.out.println(ans);
	}

	static void dfs(List<Integer> energy, int idx, int sum) {
		if (energy.size() <= 2) {
			return;
		}
		sum += energy.get(idx - 1) * energy.get(idx + 1);
		ans = Math.max(ans, sum);
		energy.remove(idx);

		for (int i = 1, c = energy.size(); i < c - 1; i++) {
			List<Integer> temp = copy(energy);
			dfs(temp, i, sum);
		}
	}

	static List copy(List<Integer> src) {
		List temp = new LinkedList<>();
		for (int i = 0, c = src.size(); i < c; i++) {
			temp.add(src.get(i));
		}
		return temp;
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
