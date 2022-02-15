/**
 * 백준 3040번
 * 백설 공주와 일곱 난쟁이
 * https://www.acmicpc.net/problem/3040
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3040 {

	static int[] arr, temp;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		temp = new int[7];
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if (cnt == 7) {
			int total = 0;
			for (int i = 0; i < temp.length; i++)
				total += temp[i];
			if (total == 100) {
				for (int i = 0; i < temp.length; i++)
					System.out.println(temp[i]);
			}
			return;
		}

		for (int i = start; i < arr.length; i++) {
			temp[cnt] = arr[i];
			combination(cnt + 1, i + 1);
		}
	}
}
