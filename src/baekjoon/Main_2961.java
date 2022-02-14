/**
 * 백준 2961번
 * 도영이가 만든 맛있는 음식
 * https://www.acmicpc.net/problem/2961
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2961 {

	static int n;
	static int[][] ingredient;
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		ingredient = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}

		subset(0, new ArrayList<>());
		int diff = Integer.MAX_VALUE;

		for (List<Integer> set : list) {
			if (set.isEmpty())
				break;
			int sour = ingredient[set.get(0)][0];
			int bit = ingredient[set.get(0)][1];
			for (int i = 1; i < set.size(); i++) {
				sour *= ingredient[set.get(i)][0];
				bit += ingredient[set.get(i)][1];
			}

			diff = Math.min(diff, Math.abs(sour - bit));
		}

		System.out.println(diff);
	}

	private static void subset(int start, List<Integer> temp) {
		if (start == n) {
			list.add(new ArrayList<>(temp));
			return;
		}
		if (temp.size() != 0) {
			list.add(new ArrayList<>(temp));
		}

		temp.add(start);
		subset(start + 1, temp);
		temp.remove(temp.size() - 1);
		subset(start + 1, temp);
	}
}
