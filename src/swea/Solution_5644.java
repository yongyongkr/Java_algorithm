/**
 * SWEA 5644번
 * 무선 충전
 */

package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5644 {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void movePoint(int dir) {
			this.x = x + dx[dir];
			this.y = y + dy[dir];
		}
	}

	static class Charger {
		Point point;
		int range;
		int power;

		public Charger(int x, int y, int range, int power) {
			this.point = new Point(x, y);
			this.range = range;
			this.power = power;
		}
	}

	private static int m, a;
	private static int[] moveA, moveB;
	private static Charger[] chargerList;
	private static Point A, B;
	private static int[] dx = {0, -1, 0, 1, 0};
	private static int[] dy = {0, 0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			chargerList = new Charger[a];
			moveA = new int[m + 1];
			moveB = new int[m + 1];
			A = new Point(0, 0);
			B = new Point(9, 9);
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++)
				moveA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++)
				moveB[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				chargerList[i] = new Charger(y - 1, x - 1, C, P);
			}
			int answer = solution();
			System.out.println("#" + t + " " + answer);
		}
	}

	private static int solution() {
		int sum = 0;
		for (int t = 0; t <= m; t++) {
			A.movePoint(moveA[t]);
			B.movePoint(moveB[t]);
			sum += getMax(getCheck(A, B));
		}
		return sum;
	}

	private static int getMax(boolean[][] check) {
		int max = 0;
		boolean checkA, checkB;
		for (int i = 0; i < a; i++) {
			checkA = check[0][i];
			for (int j = 0; j < a; j++) {
				checkB = check[1][j];
				int value = 0;
				if (i == j && checkA && checkB)
					value = chargerList[i].power;
				else {
					if (checkA)
						value += chargerList[i].power;
					if (checkB)
						value += chargerList[j].power;
				}
				max = Math.max(max, value);
			}
		}
		return max;
	}

	private static boolean[][] getCheck(Point userA, Point userB) {
		boolean[][] result = new boolean[2][a];
		for (int i = 0; i < a; i++) {
			Charger charger = chargerList[i];
			if (getDistance(userA, charger.point) <= charger.range)
				result[0][i] = true;
			if (getDistance(userB, charger.point) <= charger.range)
				result[1][i] = true;
		}
		return result;
	}

	private static int getDistance(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
