package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Programmers_퍼즐조각채우기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] game_board = { { 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
			{ 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1 },
			{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0 },
			{ 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 } };
	static int[][] table = { { 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
			{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0 },
			{ 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
			{ 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
			{ 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1 } };
	static List<List<int[]>[]> blocks;
	static List<List<int[]>> emptys;
	static boolean[][] v;
	static boolean[] b;
	static boolean[] e;
	static int y;
	static int x;
	static int ans = 0;

	static int solution(int[][] game_board, int[][] table) {
		blocks = new ArrayList<List<int[]>[]>();
		emptys = new ArrayList<List<int[]>>();
		y = table.length;
		x = table[0].length;

		v = new boolean[y][x];

		Queue<int[]> q = new LinkedList<int[]>();
		int[] dy = { 0, 0, 1, -1 };
		int[] dx = { 1, -1, 0, 0 };

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (table[i][j] == 0 || v[i][j]) {
					continue;
				}
				List<int[]> block = new ArrayList<>();
				block.add(new int[] { 0, 0 });
				q.add(new int[] { i, j });
				v[i][j] = true;

				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int ny = cur[0] + dy[k];
						int nx = cur[1] + dx[k];
						if (ny < 0 || ny >= y || nx < 0 || nx >= x || table[ny][nx] == 0 || v[ny][nx]) {
							continue;
						}
						block.add(new int[] { ny - i, nx - j });
						q.add(new int[] { ny, nx });
						v[ny][nx] = true;
					}
				}
				blocks.add(makeBlock(block));
			}
		}
		v = new boolean[y][x];

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (game_board[i][j] != 0 || v[i][j]) {
					continue;
				}
				List<int[]> empty = new ArrayList<>();
				empty.add(new int[] { 0, 0 });
				q.add(new int[] { i, j });
				v[i][j] = true;
				int miny = 50;
				int minx = 50;

				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int ny = cur[0] + dy[k];
						int nx = cur[1] + dx[k];
						if (ny < 0 || ny >= y || nx < 0 || nx >= x || game_board[ny][nx] != 0 || v[ny][nx]) {
							continue;
						}
						empty.add(new int[] { ny - i, nx - j });
						q.add(new int[] { ny, nx });
						v[ny][nx] = true;
						miny = Math.min(miny, ny - i);
						minx = Math.min(minx, nx - j);
					}
				}
				miny = miny < 0 ? miny : 0;
				minx = minx < 0 ? minx : 0;
				for (int k = 0, w = empty.size(); k < w; k++) {
					int[] cur = empty.get(k);
					cur[0] += -miny;
					cur[1] += -minx;
				}
				emptys.add(empty);
			}
		}

		b = new boolean[blocks.size()];
		e = new boolean[emptys.size()];

		for (int i = 0, c = emptys.size(); i < c; i++) {
			Loop: for (int k = 0, w = blocks.size(); k < w; k++) {
				if (b[k]) {
					continue;
				}
				for (int j = 0; j < 4; j++) {
					if (!isPoss(i, k, j)) {
						continue;
					}
					b[k] = true;
					ans += blocks.get(k)[j].size();
					break Loop;
				}
			}
		}

		return ans;

	}

	static boolean isPoss(int emptyIdx, int blockIdx, int dir) {
		List<int[]>[] block = blocks.get(blockIdx);
		List<int[]> empty = emptys.get(emptyIdx);
		if (block[0].size() != empty.size()) {
			return false;
		}
		int cnt = 0;
		for (int i = 0, c = block[dir].size(); i < c; i++) {
			int[] cur = block[dir].get(i);
			for (int j = 0, w = empty.size(); j < w; j++) {
				int[] curE = empty.get(j);
				if (curE[0] == cur[0] && curE[1] == cur[1]) {
					cnt++;
					break;
				}
			}
		}
		if (cnt == block[0].size()) {
			return true;
		}
		return false;
	}

	private static List<int[]>[] makeBlock(List<int[]> block) {
		List<int[]>[] res = new ArrayList[4];
		for (int i = 0; i < 4; i++) {
			res[i] = new ArrayList<int[]>();
		}
		int[][] resBlock = new int[4][block.size()];
		int miny = 50;
		int minx = 50;
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			miny = Math.min(miny, cur[0]);
			minx = Math.min(minx, cur[1]);
		}
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			res[0].add(new int[] { cur[0] - miny, cur[1] - minx });
		}

		miny = 50;
		minx = 50;
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			miny = Math.min(miny, -cur[0]);
			minx = Math.min(minx, -cur[1]);
		}
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			res[2].add(new int[] { -cur[0] - miny, -cur[1] - minx });
		}

		miny = 50;
		minx = 50;
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			miny = Math.min(miny, cur[1]);
			minx = Math.min(minx, -cur[0]);
		}
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			res[1].add(new int[] { cur[1] - miny, -cur[0] - minx });
		}

		miny = 50;
		minx = 50;
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			miny = Math.min(miny, -cur[1]);
			minx = Math.min(minx, cur[0]);
		}
		for (int i = 0, c = block.size(); i < c; i++) {
			int[] cur = block.get(i);
			res[3].add(new int[] { -cur[1] - miny, cur[0] - minx });
		}

		return res;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(game_board, table));
	}

}