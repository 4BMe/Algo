package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Op {
	String op;
	char num;

	public Op(String op, char num) {
		this.op = op;
		this.num = num;
	}

	@Override
	public String toString() {
		return this.op + " " + this.num;
	}
}

class Card {
	Op[] list;

	public Card(Op[] list) {
		this.list = list;
	}

}

public class BOJ_21776 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, C;
	static LinkedList<Integer>[] Seq;
	static Card[] card;
	static boolean[] choosed;
	static int[] list;

	static void init() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Seq = new LinkedList[N + 1];
		choosed = new boolean[N + 1];
		list = new int[N];
		card = new Card[C + 1];

		for (int i = 1; i <= N; i++) {
			Seq[i] = new LinkedList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			for (int j = 0, c = st.countTokens(); j < c; j++) {
				Seq[i].offer(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 1; i <= C; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			Op[] temp = new Op[st.countTokens()];
			for (int j = 0, c = st.countTokens(); j < c; j++) {
				StringTokenizer tt = new StringTokenizer(st.nextToken());
				temp[j] = new Op(tt.nextToken(), tt.nextToken().charAt(0));
			}
			card[i] = new Card(temp);
		}
	}

	static void solve() {
		dfs(0);
	}

	static void dfs(int cnt) {
		if (cnt == N) {
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (choosed[i])
				continue;
			list[cnt] = i;
			choosed[i] = true;
			dfs(cnt + 1);
			choosed[i] = false;
		}
	}

	static void go() {
		String answer = "";
		Card nCard;
		for (int i = 0; i < C; i++) {
			nCard = card[list[i]];
			for (int j = 0, w = nCard.list.length; j < w; j++) {

			}
		}
	}

	public static void main(String[] args) throws Exception {

		init();
		solve();
	}

}
