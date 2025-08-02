// INI SOAL A

import java.io.*;
import java.util.*;

public class Teio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] gain = new int[5], cost = new int[5], w = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) gain[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) cost[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) w[i] = Integer.parseInt(st.nextToken());

        int Emax = 100;
        long[] dp = new long[Emax + 1];
        long[] next = new long[Emax + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[Emax] = 0;
        
        for (int day = 0; day < D; day++) {
            Arrays.fill(next, Long.MIN_VALUE);
            for (int e = 0; e <= Emax; e++) {
                if (dp[e] < 0) continue;
                int e2 = Math.min(Emax, e + R);
                next[e2] = Math.max(next[e2], dp[e]);
                for (int i = 0; i < 5; i++) {
                    int e3 = Math.max(0, e - cost[i]);
                    long add = (e >= 50 ? 1L * gain[i] * w[i] : 0);
                    next[e3] = Math.max(next[e3], dp[e] + add);
                }
            }
            long[] tmp = dp; dp = next; next = tmp;
        }
        long ans = 0;
        for (long v : dp) ans = Math.max(ans, v);
        System.out.println(ans);
    }
}