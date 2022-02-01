/**
 * 백준 2342번
 * Dance Dance Revolution
 * https://www.acmicpc.net/problem/2342
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2342 {

	static int[][][] dp;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		list = new ArrayList<>();

		String token;
		while (!(token = st.nextToken()).equals("0")) {
			list.add(Integer.parseInt(token));
		}

		dp = new int[5][5][list.size() + 1];

		System.out.println(DDR(0, 0, 0));
	}

	private static int DDR(int left, int right, int step) {
		if (step == list.size())
			return 0;

		if (dp[left][right][step] != 0)
			return dp[left][right][step];

		int leftScore = move(left, list.get(step)) + DDR(list.get(step), right, step + 1);
		int rightScore = move(right, list.get(step)) + DDR(left, list.get(step), step + 1);

		dp[left][right][step] = Math.min(leftScore, rightScore);
		return dp[left][right][step];
	}

	private static int move(int from, int to) {
		if (from == 0)
			return 2;
		if (from == to)
			return 1;
		if (Math.abs(from - to) == 2)
			return 4;
		return 3;
	}
}
