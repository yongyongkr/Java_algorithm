/**
 * 백준 2170번
 * 선 긋기
 * https://www.acmicpc.net/problem/2170
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2170 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			arr[i][0] = left;
			arr[i][1] = right;
		}

		Arrays.sort(arr, (o1, o2) -> {
			if (o1[0] == o2[0])
				return Integer.compare(o2[1], o1[1]);
			return Integer.compare(o1[0], o2[0]);
		});

		int start = arr[0][0];
		int end = arr[0][1];
		int sum = end - start;

		for (int i = 1; i < n; i++) {
			if (end < arr[i][0]) {
				start = arr[i][0];
				end = arr[i][1];
				sum += end - start;
			} else if (end < arr[i][1]) {
				sum += arr[i][1] - end;
				end = arr[i][1];
			}
		}

		System.out.println(sum);
	}
}
