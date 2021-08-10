package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class a2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static void init() throws Exception {
	}

	static void solve() {
	}

	public static void main(String[] args) throws Exception {
		Map<String, String> voteResult = new HashMap<String, String>();
		voteResult.put("a", "c");
		voteResult.put("b", "d");
		voteResult.put("j", "d");
		voteResult.put("q", "c");
		voteResult.put("z", "c");
		voteResult.put("w", "c");
		System.out.println(voteResult.keySet().stream()
				.collect(Collectors.groupingBy(key -> voteResult.get(key))));
		System.out.println(voteResult.entrySet().stream()
				.filter(e->e.getValue().equals("d"))
				.collect(Collectors.groupingBy(e -> voteResult.get(e.getKey()))));
		System.out.println(
				voteResult.keySet().stream().collect(Collectors.groupingBy(key -> voteResult.get(key))).entrySet()
						.stream().max((entry1, entry2) -> entry1.getValue().size() > entry2.getValue().size() ? 1 : -1)
						.get().getValue().size());
	}

}
