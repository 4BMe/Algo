package kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kakao1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String s="2three45sixseven";

	static void init() throws Exception {
	}

	static void solve(String s) {
		char now;
		String sb = new String();
		for (int i = 0; i < s.length(); i++) {
			now = s.charAt(i);
			if(now<='9'&&now>='0') {
				sb+=now;
				continue;
			}
			if (now == 'z') {
				sb+=0;
				i+=3;
			} else if (now == 'o') {
				sb+=1;
				i+=2;
			} else if (now == 'e') {
				sb+=8;
				i+=4;
			} else if (now == 'n') {
				sb+=9;
				i+=3;
			} else if (now == 't') {
				if(s.charAt(i+1)=='h') {
					sb+=3;
					i+=4;
				}else {
					sb+=2;
					i+=2;
				}
			} else if (now == 'f') {
				if(s.charAt(i+1)=='o') {
					sb+=4;
					i+=3;
				}else {
					sb+=5;
					i+=3;
				}
			} else if (now == 's') {
				if(s.charAt(i+1)=='i') {
					sb+=6;
					i+=2;
				}else {
					sb+=7;
					i+=4;
				}
			}
		}
		System.out.println(Integer.parseInt(sb));
	}

	public static void main(String[] args) throws Exception {
		solve(s);
	}

}
