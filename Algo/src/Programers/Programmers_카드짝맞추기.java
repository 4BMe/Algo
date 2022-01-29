package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_카드짝맞추기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
	static int r = 1;
	static int c = 0;
	static int ans;
	static int[][] bd;
	static int x;
	static int y;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static HashMap<Integer, Card[]> hm;

	static int solution(int[][] board, int r, int c) {
		ans = Integer.MAX_VALUE;
		bd = board;
		x = r;
		y = c;
		hm = new HashMap<>();
		int i, j, k;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				k = board[i][j];
				if (k == 0) {
					continue;
				}
				if (hm.containsKey(k)) {
					hm.get(k)[1] = new Card(i, j, k, 0);
				} else {
					hm.put(k, new Card[2]);
					hm.get(k)[0] = new Card(i, j, k, 0);
				}
			}
		}

		int s = hm.size(), ks[] = new int[s], idx = 0;
		for (int kk : hm.keySet()) {
			ks[idx++] = kk;
		}

		perm(0, s, ks, new int[s], new boolean[s]);
		return ans;
	}

	static public void perm(int k, int n, int d[], int a[], boolean v[]) {
		int i, j;
		if (k == n) {
			int b[][] = new int[4][4];
			for (i = 0; i < 4; i++) {
				for (j = 0; j < 4; j++) {
					b[i][j] = bd[i][j];
				}
			}

			int cx = x, cy = y, cnt = 0, ct, c, idx = 0;
			Card cd[], cur;
			for (i = 0; i < n; i++) {
				ct = Integer.MAX_VALUE;
				cd = hm.get(d[a[i]]);
				cur = new Card(cx, cy, b[cx][cy], 0);
				for (j = 0; j < 2; j++) {
					c = 0;
					c += getMinCnt(b, cur, cd[j]) + 1;
					c += getMinCnt(b, cd[j], cd[1 - j]) + 1;
					if (ct > c) {
						ct = c;
						idx = 1 - j;
					}
				}
				cnt += ct;
				b[cd[0].x][cd[0].y] = b[cd[1].x][cd[1].y] = 0;
				cx = cd[idx].x;
				cy = cd[idx].y;
			}

			if (ans > cnt) {
				ans = cnt;
			}
		}

		for (i = 0; i < n; i++) {
			if (!v[i]) {
				v[i] = true;
				a[i] = k;
				perm(k + 1, n, d, a, v);
				v[i] = false;
			}
		}
	}

	static public int getMinCnt(int b[][], Card c1, Card c2) {
		int sx = c1.x, sy = c1.y, ex = c2.x, ey = c2.y;
		if (sx == ex && sy == ey) {
			return 0;
		}

		int x, y, m, nx, ny, nk, nm, nnx, nny, i;
		boolean v[][];
		Queue<Card> q = new LinkedList<>();
		q.add(new Card(sx, sy, b[sx][sy], 0));
		Card c;
		while (!q.isEmpty()) {
			c = q.remove();
			x = c.x;
			y = c.y;
			m = c.m;
			v = new boolean[4][4];
			v[x][y] = true;
			loop: for (i = 0; i < 4; i++) {
				/* right, down, left, up */
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || v[nx][ny]) {
					continue;
				}
				nm = m + 1;
				if (nx == ex && ny == ey) {
					return nm;
				}
				v[nx][ny] = true;
				nk = b[nx][ny];
				q.add(new Card(nx, ny, nk, nm));
				if (nk > 0) {
					continue;
				}
				nx += dx[i];
				ny += dy[i];
				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
					continue;
				}
				while (true) {
					if (v[nx][ny]) {
						continue loop;
					}
					v[nx][ny] = true;
					if (nx == ex && ny == ey) {
						return nm;
					}
					nk = b[nx][ny];
					if (nk > 0) {
						q.add(new Card(nx, ny, nk, nm));
						continue loop;
					}
					nnx = nx + dx[i];
					nny = ny + dy[i];
					if (nnx < 0 || nnx >= 4 || nny < 0 || nny >= 4) {
						break;
					}
					nx += dx[i];
					ny += dy[i];
				}
				q.add(new Card(nx, ny, nk, nm));
			}
		}
		return 0;
	}

	static class Card {
		int x, y, k, m;

		Card(int x, int y, int k, int m) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.m = m;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(board, r, c));
	}

}