/**
 * 백준 22862번
 * 가장 긴 짝수 연속한 부분 수열
 * https://www.acmicpc.net/problem/22862
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main_22862 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 0) {
                count++;
                if (i == n - 1) {
                    list.add(count);
                }
            } else {
                list.add(count);
                count = 0;
            }
        }

        if (list.size() <= k) {
            System.out.println(list.stream().mapToInt(Integer::intValue).sum());
            return;
        }

        List<Integer> prefixSum = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < k + 1; i++) {
            temp += list.get(i);
        }
        prefixSum.add(temp);

        for (int i = k + 1; i < list.size(); i++) {
            prefixSum.add(prefixSum.get(i - k - 1) + list.get(i) - list.get(i - k - 1));
        }

        System.out.println(Collections.max(prefixSum));
    }
}
