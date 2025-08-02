// INI SOAL B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakushin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] T = new long[D];
        long[] R = new long[D];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            T[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            R[i] = Long.parseLong(st.nextToken());
        }

        long base = 0L;
        for (long t : T) {
            base += t;
        }

        long[][] dp = new long[D + 2][S + 1];

        for (int i = D - 1; i >= 0; i--) {
            for (int s = 0; s <= S; s++) {
                long best = dp[i + 1][s];
                if (s > 0) {
                    int j = Math.min(D, i + C + 1);
                    best = Math.max(best, R[i] + dp[j][s - 1]);
                }
                dp[i][s] = best;
            }
        }

        long maxReduction = dp[0][S];
        long result = base - maxReduction;
        System.out.println(result);
    }
}