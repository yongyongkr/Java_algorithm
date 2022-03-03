/**
 * 백준 2110번
 * 공유기 설치
 * https://www.acmicpc.net/problem/2110
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] house = new int[n];
		for (int i = 0; i < n; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		int answer = 0;
		int left = 1;
		int right = house[n - 1] - house[0];
		while (left <= right) {
			int count = 0;
			int start = house[0];
			int mid = (left + right) / 2;
			for (int i = 1; i < n; i++) {
				if (house[i] - start >= mid) {
					count++;
					start = house[i];
				}
			}
			if (count >= c - 1) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}
}
