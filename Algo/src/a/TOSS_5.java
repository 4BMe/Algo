package a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TOSS_5 {

	static void init() throws Exception {
		int[] fruitWeights = { 10, 50, 20, 40, 20, 30 };
		int k = 3;
		int[] dp = new int[fruitWeights.length];
		Map<Integer, Boolean> poss = new HashMap();

		Arrays.fill(dp, -1);

		for (int j = 0, c = fruitWeights.length; j < c - k + 1; j++) {
			dp[j] = fruitWeights[j];
		}

		for (int i = 1; i < k; i++) {
			for (int j = 0, c = fruitWeights.length; j < c - i; j++) {
				dp[j] = Math.max(dp[j], fruitWeights[i + j]);
			}
		}
		for (int j = 0, c = fruitWeights.length; j < c - k + 1; j++) {
			if (dp[j] == -1)
				continue;
			poss.put(dp[j], true);
		}

		List<Integer> a = poss.keySet().stream().collect(Collectors.toList());
		Collections.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		int[] answer = new int[a.size()];
		for (int i = 0, c = a.size(); i < c; i++) {
			answer[i] = a.get(i);
			System.out.println(answer[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		init();
	}

}
