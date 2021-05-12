package kakao;

public class kakao5 {
	static int[][] links = { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { 8, 5 }, { 2, 10 }, { 3, 0 }, { 6, 1 },
			{ 11, -1 }, { 7, 4 }, { -1, -1 }, { -1, -1 } };
	static int k = 3;
	static int[] num = { 12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1 };
	static int[] p;
	static int answer = Integer.MAX_VALUE;

	static void solve() {
		cut(0, 0);
		System.out.println(answer);
	}

	static void cut(int idx, int cnt) {
		if (idx > num.length * 2) {
			return;
		}
		if (cnt == k - 1) {
			makeg();
		}

		int temp;
		for (int i = idx, c = num.length * 2; i < c; i++) {
			if (links[i / 2][i % 2] == -1)
				continue;
			temp = links[i / 2][i % 2];
			links[i / 2][i % 2] = -1;
			cut(i + 1, cnt + 1);
			links[i / 2][i % 2] = temp;
		}
	}

	static void makeg() {
		int length = num.length;
		p = new int[length];
		for (int i = 0; i < length; i++)
			p[i] = i;

		for (int i = 0; i < length; i++) {
			if (links[i][0] != -1) {
				union(i, links[i][0]);
			}
			if (links[i][1] != -1) {
				union(i, links[i][1]);
			}

		}
		for (int i = 0; i < length; i++) {
			find(i);
		}

		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[p[i]] += num[i];
		}

		int a = 0;
		for (int i = 0; i < length; i++)
			a = Math.max(a, result[i]);
		answer = Math.min(answer, a);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			p[y] = x;
		else
			p[x] = y;
	}

	static int find(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = find(p[x]);
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
