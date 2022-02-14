/**
 * SWEA 6808번
 * 규영이와 인영이의 카드게임
 */

package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_6808 {

	static int[] arr;
	static boolean[] visited;
	static List<int[]> permutationList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());

		int totalSum = 0;
		for (int i = 1; i <= 18; i++) {
			totalSum += i;
		}

		arr = new int[9];
		visited = new boolean[9];
		permutation(0);

		for (int tc = 1; tc <= testcase; tc++) {
			List<Integer> myCard = new ArrayList<>();
			List<Integer> comCard = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				myCard.add(Integer.parseInt(st.nextToken()));
			}

			for (int i = 1; i <= 18; i++) {
				if (!myCard.contains(i))
					comCard.add(i);
			}

			int win = 0;
			int lose = 0;

			for (int[] ints : permutationList) {
				int curPoint = 0;
				for (int i = 0; i < 9; i++) {
					if (myCard.get(i) > comCard.get(ints[i])) {
						curPoint += myCard.get(i) + comCard.get(ints[i]);
					}
				}
				if (curPoint >= totalSum / 2.0) {
					win++;
				} else {
					lose++;
				}
			}

			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}

	private static void permutation(int depth) {
		if (depth == 9) {
			permutationList.add(Arrays.copyOf(arr, arr.length));
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[depth] = i;
			permutation(depth + 1);
			visited[i] = false;
		}
	}
}
