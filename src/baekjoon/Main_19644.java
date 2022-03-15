/**
 * 백준 19644번
 * 좀비 떼가 기관총 진지에도 오다니
 * https://www.acmicpc.net/problem/19644
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19644 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int gunRange = Integer.parseInt(st.nextToken());
		int gunPower = Integer.parseInt(st.nextToken());

		int mines = Integer.parseInt(br.readLine());

		Queue<Integer> mineUsed = new LinkedList<>();
		boolean possible = true;
		int start = -1 * gunRange + 1;
		int end = 0;
		int gunUsed = 1;
		while (end < len) {
			int zombie = Integer.parseInt(br.readLine());
			int shootDam = gunPower * gunUsed;
			if (shootDam < zombie) {
				if (mines-- == 0) {
					possible = false;
					break;
				}
				gunUsed--;
				mineUsed.offer(end);
			}
			if (start < 0) {
				gunUsed++;
			} else if (!mineUsed.isEmpty() && mineUsed.peek() == start) {
				mineUsed.poll();
				gunUsed++;
			}
			start++;
			end++;
		}

		if (possible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
