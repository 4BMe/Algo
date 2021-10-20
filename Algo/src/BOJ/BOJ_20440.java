package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class MOS {
	int time;
	boolean in;

	public MOS(int time, boolean in) {
		this.time = time;
		this.in = in;
	}
}

public class BOJ_20440 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static MOS[] mos;
	static int ans = 0;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		mos = new MOS[n * 2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			mos[i * 2] = new MOS(Integer.parseInt(st.nextToken()), true);
			mos[i * 2 + 1] = new MOS(Integer.parseInt(st.nextToken()), false);
		}
		Arrays.sort(mos, new Comparator<MOS>() {
			@Override
			public int compare(MOS o1, MOS o2) {
				return o1.time - o2.time;
			}
		});
	}

	static void solve() {
		int cnt = 0;
		int start = 0;
		int end = 0;
		boolean con = false;
		for (int i = 0; i < n * 2; i++) {
			MOS now = mos[i];
			if (i < n * 2 - 1) {
				MOS next = mos[i + 1];
				if (now.time == next.time && ((!now.in && next.in) || (now.in && !next.in))) {
					i++;
					continue;
				}
			}
			if (now.in) {
				cnt++;
				if (cnt > ans) {
					ans = cnt;
					start = now.time;
					con = true;
				}
			} else {
				if (con) {
					end = now.time;
					con = false;
				}
				cnt--;
			}
		}
		System.out.println(ans + "\n" + start + " " + end);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}