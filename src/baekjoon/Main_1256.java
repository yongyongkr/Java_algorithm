/**
 * 백준 1256번
 * 사전
 * https://www.acmicpc.net/problem/1256
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1256 {

	static int n, m;
	static BigInteger k;
	static BigInteger[] factorial;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = new BigInteger(st.nextToken());

		factorial = new BigInteger[201];
		factorial[0] = new BigInteger(String.valueOf(1));
		initializeFactorial(factorial);

		BigInteger totalCases = getNumOfCombinations(n, m);
		if (totalCases.compareTo(k) == -1) {
			System.out.println(-1);
			return;
		}

		k = k.subtract(BigInteger.valueOf(1));
		while (true) {
			if (n == 0 || m == 0)
				break;
			BigInteger cases = getNumOfCombinations(n - 1, m);
			if (cases.compareTo(k) == 1) {
				sb.append("a");
				n--;
			} else {
				sb.append("z");
				m--;
				k = k.subtract(cases);
			}
		}

		while (n-- > 0) {
			sb.append("a");
		}

		while (m-- > 0) {
			sb.append("z");
		}

		System.out.println(sb.toString());
	}

	private static BigInteger getNumOfCombinations(int n, int m) {
		return factorial[n + m].divide(factorial[n].multiply(factorial[m]));
	}

	private static void initializeFactorial(BigInteger[] factorial) {
		for (int i = 1; i < 201; i++) {
			factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
		}
	}
}
