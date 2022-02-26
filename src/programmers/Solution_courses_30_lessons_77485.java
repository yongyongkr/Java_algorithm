/**
 * 프로그래머스
 * 행렬 테두리 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 */

package programmers;

public class Solution_courses_30_lessons_77485 {

	static int[] minValues;
	static int[][] arr;

	public int[] solution(int rows, int columns, int[][] queries) {

		arr = new int[rows][columns];
		int num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr[i][j] = num++;
			}
		}

		minValues = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int x1 = queries[i][0] - 1;
			int y1 = queries[i][1] - 1;
			int x2 = queries[i][2] - 1;
			int y2 = queries[i][3] - 1;

			int min = cycle(x1, y1, x2, y2);
			minValues[i] = min;
		}

		return minValues;
	}

	private int cycle(int x1, int y1, int x2, int y2) {
		int temp = arr[x1][y1];
		int min = temp;

		for (int row = x1; row < x2; row++) {
			arr[row][y1] = arr[row + 1][y1];
			min = Math.min(min, arr[row][y1]);
		}

		for (int col = y1; col < y2; col++) {
			arr[x2][col] = arr[x2][col + 1];
			min = Math.min(min, arr[x2][col]);
		}

		for (int row = x2; row > x1; row--) {
			arr[row][y2] = arr[row - 1][y2];
			min = Math.min(min, arr[row][y2]);
		}

		for (int col = y2; col > y1; col--) {
			arr[x1][col] = arr[x1][col - 1];
			min = Math.min(min, arr[x1][col]);
		}

		arr[x1][y1 + 1] = temp;
		return min;
	}
}
