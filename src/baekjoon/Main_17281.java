/**
 * 백준 17281번
 * 야구공
 * https://www.acmicpc.net/problem/17281
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

		boolean[] visited = new boolean[9];
		int[] order = new int[9];
		visited[3] = true;
		order[3] = 0;
		permutation(1, visited, order);

		System.out.println(maxScore);
	}

	private static void permutation(int player, boolean[] visited, int[] order) {
		if (player == 9) {
			calculateScore(order);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			order[i] = player;
			permutation(player + 1, visited, order);
			visited[i] = false;
		}
	}

	private static void calculateScore(int[] order) {
		int totalScore = 0;
		int idx = 0;
		for (int i = 0; i < game.length; i++) {
			int outCnt = 0;
			Queue<Integer> q = new LinkedList<>();
			while (outCnt < 3) {
				int player = order[idx++];
				if (idx == 9) {
					idx = 0;
				}
				int score = game[i][player];
				if (score == 0) {
					outCnt++;
					continue;
				}
				q.offer(0);
				int size = q.size();
				while (size-- > 0) {
					int poll = q.poll();
					if (poll + score >= 4) {
						totalScore++;
					} else {
						q.offer(poll + score);
					}
				}
			}
		}
		maxScore = Math.max(maxScore, totalScore);
	}
}
