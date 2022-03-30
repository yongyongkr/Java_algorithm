/**
 * 백준 17281번
 * 야구공
 * https://www.acmicpc.net/problem/17281
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281 {

	static int[][] game;
	static int maxScore = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		game = new int[n][9];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				game[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] order = new int[9];
		Arrays.fill(order, -1);
		order[3] = 0;
		permutation(1, order);

		System.out.println(maxScore);
	}

	private static void permutation(int player, int[] order) {
		if (player == 9) {
			calculateScore(order);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (order[i] != -1)
				continue;
			order[i] = player;
			permutation(player + 1, order);
			order[i] = -1;
		}
	}

	private static void calculateScore(int[] order) {
		int totalScore = 0;
		int idx = 0;
		for (int[] ints : game) {
			int outCnt = 0;
			int base = 0;
			while (outCnt < 3) {
				int player = order[idx++ % 9];
				int score = ints[player];
				if (score == 0) {
					outCnt++;
					continue;
				}
				base <<= score;
				base |= 1 << score;
				int cur = base % (1 << 4);
				totalScore += Integer.bitCount(base) - Integer.bitCount(cur);
				base = cur;
			}
		}
		maxScore = Math.max(maxScore, totalScore);
	}
}
