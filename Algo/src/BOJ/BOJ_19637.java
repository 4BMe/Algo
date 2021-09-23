package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19637 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int m;
	static List<ch> ching = new ArrayList<ch>();
	static boolean[] check;
	static int[] player;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int max = Integer.parseInt(st.nextToken());

			ching.add(new ch(name, max));

		}

		sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int p = Integer.parseInt(br.readLine());
			int right = ching.size() - 1;
			int left = 0;
			String res = "";
			while (left <= right) {
				int mid = (left + right) / 2;

				ch mch = ching.get(mid);

				if (mch.max >= p) {
					res = mch.name;
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		init();
	}

}

class ch {
	String name;
	int max;

	public ch(String name, int max) {
		this.name = name;
		this.max = max;
	}
}