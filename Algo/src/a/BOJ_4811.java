package a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4811 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int n;
	static long[][] dp;
	static int half;

	static void init() throws Exception {
		sb = new StringBuilder();
		dp = new long[31][31];
		for(int i=0; i<=30; i++) {
			for(int j=0; j<=30; j++) {
				if(i>j)continue;
				if(i==0)dp[j][i]=1;
				else dp[j][i]=dp[j-1][i]+dp[j][i-1];
			}
		}
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				System.out.println(sb);
				return;
			}
			sb.append(dp[n][n] + "\n");
		}
	}

	public static void main(String[] args) throws Exception {

		init();
	}

}
