// INI SOAL D

import java.io.*;
import java.util.*;

public class Bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] mask = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mask[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxGroup = 0;
        int totalSubsets = 1 << N;
        
        int[] dp = new int[totalSubsets];
        dp[0] = (1 << M) - 1;
        
        for (int s = 1; s < totalSubsets; s++) {
            int lsb = s & -s;
            int idx = Integer.numberOfTrailingZeros(lsb);
            int prev = s ^ lsb;
            dp[s] = dp[prev] & mask[idx];
            
            if (dp[s] == 0) {
                int size = Integer.bitCount(s);
                if (size > maxGroup) {
                    maxGroup = size;
                }
            }
        }
        
        System.out.println(maxGroup);
    }
}