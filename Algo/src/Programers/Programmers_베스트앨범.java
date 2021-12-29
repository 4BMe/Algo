package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Programmers_베스트앨범 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static String[] genres = { "classic", "pop", "classic", "classic", "pop" };
	static int[] plays = { 500, 600, 150, 800, 2500 };

	static int[] solution(String[] genres, int[] plays) {
		Map<String, Integer> sums = new LinkedHashMap<>();
		Map<String, List<int[]>> lists = new HashMap<>();
		for (int i = 0, c = genres.length; i < c; i++) {
			String s = genres[i];
			sums.put(s, sums.getOrDefault(s, 0) + plays[i]);
			List<int[]> list = lists.getOrDefault(s, new LinkedList<int[]>());
			list.add(new int[] { i, plays[i] });
			lists.put(s, list);
		}

		List<Integer> ans = new LinkedList<>();
		List<Map.Entry<String, Integer>> entries = new LinkedList<>(sums.entrySet());
		Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
		for (Map.Entry<String, Integer> entry : entries) {
			String k = entry.getKey();
			List<int[]> list = lists.get(k);
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}
			});
			ans.add(list.get(0)[0]);
			if (list.size() > 1) {
				ans.add(list.get(1)[0]);
			}
		}

		return ans.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) throws Exception {
		for (int a : solution(genres, plays)) {
			System.out.print(a + " ");
		}
	}

}