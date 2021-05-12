package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class kakao3 {

	static void solve(int n, int k, String[] cmd) {
		boolean[] dead = new boolean[n];
		Stack<Integer> dlist = new Stack<>();
		ArrayList<Integer> alist = new ArrayList<>();
		for (int i = 0; i < n; i++)
			alist.add(i);
		
		
		char cm;
		int back;
		int idx = k;
		for (int i = 0, c = cmd.length; i < c; i++) {
			cm = cmd[i].charAt(0);
			System.out.println(idx+" k");
			if (cm == 'U') {
				idx -= (cmd[i].charAt(2) - '0');
			} else if (cm == 'D') {
				idx += (cmd[i].charAt(2) - '0');
			} else if (cm == 'Z') {
				back = dlist.pop();
				dead[back] = false;
				if (back < alist.get(idx))
					idx++;
                alist.add(back);
				Collections.sort(alist);
			} else if (cm == 'C') {
				back = alist.get(idx);
				System.out.println(back);
				dlist.add(back);
				dead[back] = true;
				alist.remove(idx);
			}
		}

		String answer = "";
		for (int i = 0; i < n; i++)
			if (!dead[i])
				answer += "O";
			else
				answer += "X";
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		String[] cmd = { "D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		solve(8, 2, cmd);
	}
}
