// Ini soal B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Apakah {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
 
        boolean[][] seen = new boolean[N][M];
 
        int[] dx = {-1, 1, 0, 0};  
        int[] dy = {0, 0, -1, 1};
 
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
 
            if (grid[x][y] == '?') {
                seen[x][y] = true;
            }
 
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
 
                while (nx >= 0 && nx < N && ny >= 0 && ny < M && grid[nx][ny] != '#') {
                    if (grid[nx][ny] == '?') {
                        seen[nx][ny] = true;
                    }
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }
        }
 
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '?' && seen[i][j]) {
                    result++;
                }
            }
        }
 
        System.out.println(result);
    }
}