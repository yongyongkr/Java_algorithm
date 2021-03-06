/**
 * 백준 14499번
 * 주사위 굴리기
 * https://www.acmicpc.net/problem/14499
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_14499 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            changeDice(dir, dice);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            System.out.println(dice[1]);
        }
    }

    private static void changeDice(int dir, int[] dice) {
        int[] temp = dice.clone();

        if (dir == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (dir == 2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[6] = temp[4];
            dice[4] = temp[1];
        } else if (dir == 3) {
            dice[1] = temp[5];
            dice[5] = temp[6];
            dice[6] = temp[2];
            dice[2] = temp[1];
        } else {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[6] = temp[5];
            dice[5] = temp[1];
        }
    }
}
