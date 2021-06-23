package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Operation {
	int idx, num;
	String op;

	public Operation(int idx, String op) {
		this.idx = idx;
		this.op = op;
	}

	public Operation(int idx, String op, int num) {
		this.idx = idx;
		this.op = op;
		this.num = num;
	}

}

public class BOJ_21775 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, T;
	static int[] Sequence;
	static Operation[] hand;
	static Queue<Operation> op = new LinkedList<Operation>();
	static HashMap<Integer, Integer> num = new HashMap<>();

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		hand = new Operation[N + 1];
		Sequence = new int[T];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			Sequence[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.countTokens() == 2) {
				op.offer(new Operation(Integer.parseInt(st.nextToken()), st.nextToken()));
			} else {
				op.offer(new Operation(Integer.parseInt(st.nextToken()), st.nextToken(),
						Integer.parseInt(st.nextToken())));
			}
		}

	}

	static void solve() {
		sb = new StringBuilder();
		Operation now;
		for (int i = 0; i < T; i++) {
			int player = Sequence[i];
			now = hand[player];
			if (now == null)
				now = op.poll();

			sb.append(now.idx + "\n");
			if (now.op.equals("next")) {
				hand[player] = null;
			} else if (now.op.equals("acquire")) {
				if (num.get(now.num) == null) {
					num.put(now.num, player);
					hand[player] = null;
				} else
					hand[player] = now;

			} else {
				num.remove(now.num);
				hand[player] = null;
			}
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
