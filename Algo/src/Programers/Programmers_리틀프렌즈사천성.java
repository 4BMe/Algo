package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Programmers_리틀프렌즈사천성 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int m;
	static int n;
	static String[] board;

	static String solution(int M, int N, String[] B) {
		m = M;
		n = N;
		board = B;
		Map<Character, List<int[]>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char now = board[i].charAt(j);
				if (now == '.' || now == '*') {
					continue;
				}
				List<int[]> list = map.getOrDefault(now, new LinkedList<>());
				list.add(new int[] { i, j });
				map.put(now, list);
			}
		}

		List<Tile> tiles = new ArrayList<>();
		for (Entry<Character, List<int[]>> entry : map.entrySet()) {
			tiles.add(new Tile(entry.getKey(), entry.getValue()));
		}
		Collections.sort(tiles, new Comparator<Tile>() {
			@Override
			public int compare(Tile o1, Tile o2) {
				return o1.ch - o2.ch;
			}
		});

		boolean flag = true;
		StringBuilder sb = new StringBuilder();

		while (flag) {
			flag = false;
			for (int i = 0, c = tiles.size(); i < c; i++) {
				Tile now = tiles.get(i);
				List<int[]> list = now.list;
				int[] start = list.get(0);
				int[] end = list.get(1);
				char delete = now.ch;
				if (isPossible(start, end, delete)) {
					flag = true;
					tiles.remove(i);
					sb.append(delete);
					for (int j = 0; j < m; j++) {
						board[j] = board[j].replace(delete, '.');
					}
					break;
				}
			}
		}
		if (!tiles.isEmpty()) {
			return "IMPOSSIBLE";
		}

		return sb.toString();
	}

	static boolean isPossible(int[] start, int[] end, char delete) {
		if (start[1] <= end[1]) {
			boolean right = true;
			for (int i = start[1]; i <= end[1]; i++) {
				if (board[start[0]].charAt(i) == '.' || board[start[0]].charAt(i) == delete) {
					continue;
				}
				right = false;
			}

			boolean down = true;
			for (int i = start[0]; i <= end[0]; i++) {
				if (board[i].charAt(end[1]) == '.' || board[i].charAt(end[1]) == delete) {
					continue;
				}
				down = false;
			}

			if (right && down) {
				return true;
			}

			down = true;
			for (int i = start[0]; i <= end[0]; i++) {
				if (board[i].charAt(start[1]) == '.' || board[i].charAt(start[1]) == delete) {
					continue;
				}
				down = false;
			}

			right = true;
			for (int i = start[1]; i <= end[1]; i++) {
				if (board[end[0]].charAt(i) == '.' || board[end[0]].charAt(i) == delete) {
					continue;
				}
				right = false;
			}

			if (right && down) {
				return true;
			}
		} else {
			boolean right = true;
			for (int i = end[1]; i <= start[1]; i++) {
				if (board[start[0]].charAt(i) == '.' || board[start[0]].charAt(i) == delete) {
					continue;
				}
				right = false;
			}

			boolean down = true;
			for (int i = start[0]; i <= end[0]; i++) {
				if (board[i].charAt(end[1]) == '.' || board[i].charAt(end[1]) == delete) {
					continue;
				}
				down = false;
			}

			if (right && down) {
				return true;
			}

			down = true;
			for (int i = start[0]; i <= end[0]; i++) {
				if (board[i].charAt(start[1]) == '.' || board[i].charAt(start[1]) == delete) {
					continue;
				}
				down = false;
			}

			right = true;
			for (int i = end[1]; i <= start[1]; i++) {
				if (board[end[0]].charAt(i) == '.' || board[end[0]].charAt(i) == delete) {
					continue;
				}
				right = false;
			}

			if (right && down) {
				return true;
			}
		}

		return false;
	}

	static class Tile {
		char ch;
		List<int[]> list;

		public Tile(char ch, List<int[]> list) {
			this.ch = ch;
			this.list = list;
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println(solution(4, 4, new String[] { ".ZI.", "M.**", "MZU.", ".IU." }));
	}

}