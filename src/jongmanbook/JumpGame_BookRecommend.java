/**
 * 종만북
 * 외발 뛰기
 * https://algospot.com/judge/problem/read/JUMPGAME
 */

package jongmanbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumpGame_BookRecommend {

	static int r, c;
	static int[][] map, cache;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// System.out.println(jump(0, 0));

		cache = new int[r][c];
		for (int i = 0; i < r; i++) {
			Arrays.fill(cache[i], - 1);
		}

		if (jump2(0, 0) == 1) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	// 외발 뛰기 문제를 해결하는 재귀 호출 알고리즘
	private static boolean jump(int x, int y) {
		if (x == r - 1 && y == c - 1) {
			return true;
		}

		if (x >= r || y >= c) {
			return false;
		}

		int jumpSize = map[x][y];
		return jump(x + jumpSize, y) || jump(x, y + jumpSize);
	}

	// 외발 뛰기 문제를 해결하는 동적 계획법 알고리즘
	private static int jump2(int x, int y) {
		if (x == r - 1 && y == c - 1) {
			return 1;
		}

		if (x >= r || y >= c) {
			return 0;
		}

		if (cache[x][y] != -1) {
			return cache[x][y];
		}

		int jumpSize = map[x][y];
		return cache[x][y] = jump2(x + jumpSize, y) == 1 || jump2(x, y + jumpSize) == 1 ? 1 : 0;
}
}
