package hard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_순위검색 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;

	static int[] solve() {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		Map<String, List<Integer>> infos = new HashMap<>();
		for (String in : info) {
			String[] split = in.split(" ");
			int score = Integer.parseInt(split[4]);

			for (int i = 0; i < (1 << 4); i++) {
				StringBuilder key = new StringBuilder();
				for (int j = 0; j < 4; j++) {
					if ((i & (1 << j)) > 0)
						key.append(split[j]);
				}
				infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
			}
		}

		List<Integer> empty = new ArrayList<>();
		for (Map.Entry<String, List<Integer>> entry : infos.entrySet())
			entry.getValue().sort(null);

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] split = query[i].replaceAll("-", "").split(" and | ");
			String key = String.join("", split[0], split[1], split[2], split[3]);
			int score = Integer.parseInt(split[4]);

			List<Integer> list = infos.getOrDefault(key, empty);

			int s = 0, e = list.size();

			while (s < e) {
				int mid = (s + e) / 2;

				if (list.get(mid) < score)
					s = mid + 1;
				else
					e = mid;
			}

			answer[i] = list.size() - s;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		for (int a : solve()) {
			System.out.print(a + " ");
		}
	}

}