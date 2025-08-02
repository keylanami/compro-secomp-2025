// INI SOAL D

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Golshi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        int[] W = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(W);

        long sum = 0;
        int cnt = 0;
        for (int w : W) {
            if (sum + w <= C) {
                sum += w;
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}