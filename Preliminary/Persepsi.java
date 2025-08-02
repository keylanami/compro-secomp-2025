// INI SOAL C

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Persepsi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Map<Long, Long> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long p = Long.parseLong(st.nextToken());
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }
        
        long result = 0;
        for (long count : freq.values()) {
            result += count * (count - 1) / 2;
        }
        
        System.out.println(result);
    }
}