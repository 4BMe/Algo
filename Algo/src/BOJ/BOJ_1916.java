package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n, m;
	static List<int[]>[] bus;
	static int[] dist;
	static int start, dest;

	static void init() throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		bus = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			bus[i] = new ArrayList<>();

		int from, to, cost;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			bus[from].add(new int[] { to, cost });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());

	}

	static void solve() {
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		q.offer(new int[] { start, 0 });

		int[] cur;
		int[] next;
		while (!q.isEmpty()) {
			cur = q.poll();
//			System.out.println("현재"+cur[0]+" "+cur[1]);
			for (int i = 0, c = bus[cur[0]].size(); i < c; i++) {
				next = bus[cur[0]].get(i);
				if (dist[next[0]] > cur[1] + next[1]) {
					dist[next[0]] = cur[1] + next[1];
					q.add(new int[] { next[0], cur[1] + next[1] });
//					System.out.println(next[0] + " " + (cur[1] + next[1]));
				}
			}
		}

		System.out.println(dist[dest]);

	}

	public static void main(String[] args) throws Exception {
		init();
		solve();
	}

}
