/**
 * 종만북
 * 록 페스티벌
 * https://algospot.com/judge/problem/read/FESTIVAL
 */

package jongmanbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RockFestival {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int days = Integer.parseInt(st.nextToken());
			int teams = Integer.parseInt(st.nextToken());

			int[] costs = new int[days];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < days; i++) {
				costs[i] = Integer.parseInt(st.nextToken());
			}

			double avg = Double.MAX_VALUE;

			for (int i = teams; i <= days; i++) {
				double totalSum = 0;
				for (int j = 0; j < i; j++) {
					totalSum += costs[j];
				}

				double sum = totalSum;
				for (int j = i; j < days; j++) {
					sum += costs[j] - costs[j - i];
					totalSum = Math.min(totalSum, sum);
				}

				avg = Math.min(avg, totalSum / i);
			}

			System.out.printf("%.10f\n", avg);
		}
	}
}
