/**
 * 백준 2224번
 * 명제 증명
 * https://www.acmicpc.net/problem/2224
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2224 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int x = Integer.parseInt(br.readLine());
		int[][] arr = new int[58][58];
		int count = 0;

		for (int i = 0; i < x; i++) {
			String str = br.readLine();
			char a = str.charAt(0);
			char b = str.charAt(5);
			if (a == b) {
				continue;
			}
			if (arr[a - 'A'][b - 'A'] == 0) {
				arr[a - 'A'][b - 'A'] = 1;
				count++;
			}
		}

		for (int k = 0; k < 58; k++) {
			for (int i = 0; i < 58; i++) {
				for (int j = 0; j < 58; j++) {
					if (i != j && arr[i][j] == 0 && arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
						count++;
					}
				}
			}
		}

		bw.write(count + "");
		bw.write("\n");
		for (int i = 0; i < 58; i++) {
			for (int j = 0; j < 58; j++) {
				if (arr[i][j] == 1) {
					bw.write(i + 'A');
					bw.write(" => ");
					bw.write(j + 'A');
					bw.write("\n");
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
