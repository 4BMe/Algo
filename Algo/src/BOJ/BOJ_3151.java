package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3151 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int[] num;
	static int ans = 0;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int su = Integer.parseInt(st.nextToken());
			num[i] = su;
		}
	}

	static void solve() {
		Arrays.sort(num);
		for (int i = 0; i < n - 1; i++) {
			int foot = -num[i];
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int lnum = num[left];
				int rnum = num[right];
				if (lnum + rnum < foot) {
					left++;
				} else if (lnum + rnum > foot)
					right--;
				else {
					if (lnum == rnum) {
						ans += (right - left + 1) * (right - left) / 2;
						break;
					} else {
						int rcnt = 0;
						while (true) {
							if (num[right] != rnum)
								break;
							right--;
							rcnt++;
						}
						int lcnt = 0;
						while (true) {
							if (num[left] != lnum)
								break;
							left++;
							lcnt++;
						}
						ans += lcnt * rcnt;
					}
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
