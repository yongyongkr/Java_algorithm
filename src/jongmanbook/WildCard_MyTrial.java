/**
 * 종만북
 * 와일드 카드
 * https://algospot.com/judge/problem/read/WILDCARD
 */

package jongmanbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildCard_MyTrial {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			String str = br.readLine();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '?') {
					sb.append("\\w");
				} else if (c == '*') {
					sb.append("[a-zA-Z0-9]*");
				} else {
					sb.append(c);
				}
			}

			Pattern pattern = Pattern.compile(sb.toString());

			int n = Integer.parseInt(br.readLine());

			List<String> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String fileName = br.readLine();
				Matcher matcher = pattern.matcher(fileName);
				if (matcher.matches()) {
					list.add(fileName);
				}
			}

			Collections.sort(list);
			for (String s : list) {
				System.out.println(s);
			}
		}
	}
}
