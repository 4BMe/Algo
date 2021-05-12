package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kakao2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };

	static void solve(String[][] places) {
		int[] answer = new int[5];
		Arrays.fill(answer, 1);

		for (int i = 0; i < 5; i++) {
			System.out.println((i + 1));
			start:
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if (places[i][j].charAt(k) == 'P')
						if (!bfs(i, j, k, places)) {
							answer[i] = 0;
							break start;
						}
				}
			}
		}
		for(int i=0;i<5; i++) {
			System.out.print(answer[i]+" ");
		}
	}

	static boolean bfs(int idx, int y, int x, String[][] places) {
		Queue<int[]> q = new LinkedList<>();
		boolean visited[][] = new boolean[5][5];
		q.offer(new int[] { y, x, 0 });
		visited[y][x] = true;
//		System.out.println(idx + 1);
		int[] cur;
		while (!q.isEmpty()) {
			cur = q.poll();
//			System.out.println(cur[0] + " " + cur[1] + " " + cur[2]);
			for (int i = 0; i < 4; i++) {
				y = cur[0] + dy[i];
				x = cur[1] + dx[i];
				if (y >= 5 || y < 0 || x >= 5 || x < 0 || places[idx][y].charAt(x) == 'X' || visited[y][x]
						|| cur[2] >= 2)
					continue;
				if (places[idx][y].charAt(x) == 'O') {
					q.add(new int[] { y, x, cur[2] + 1 });
					visited[y][x] = true;
				} else
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		solve(places);
	}
}
