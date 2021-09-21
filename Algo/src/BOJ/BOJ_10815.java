package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10815 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static int m;
	static boolean[] pl;
	static boolean[] mi;
	static boolean[] card;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		pl = new boolean[10000000];
		mi = new boolean[10000000];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t>=0)pl[t]=true;
			else mi[-t]=true;
		}

		m = Integer.parseInt(br.readLine());
		card = new boolean[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t>=0) {
				if(pl[t])card[i]=true;
			}
			else {
				if(mi[-t])card[i]=true;
			}
		}
		for(boolean a : card)
			System.out.print(a==true?1+" ":0+" ");
	}

	static void solve() {
	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
