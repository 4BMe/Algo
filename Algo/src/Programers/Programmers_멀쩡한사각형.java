package Programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Programmers_멀쩡한사각형 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;

	static long solve(int w, int h) {
		int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		return ((long) w * h) - (((w / gcd) + (h / gcd) - 1) * (long) gcd);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(solve(100000000, 100000000));
	}

}