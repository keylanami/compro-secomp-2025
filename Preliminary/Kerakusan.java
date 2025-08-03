// Ini Soal A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Kerakusan {
    static class Mine implements Comparable<Mine> {
        long value, decay;
        Mine(long value, long decay) {
            this.value = value;
            this.decay = decay;
        }
        @Override
        public int compareTo(Mine other) {
            return Long.compare(other.value, this.value);
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        PriorityQueue<Mine> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long D = Long.parseLong(st.nextToken());
            if (A > 0) {
                pq.offer(new Mine(A, D));
            }
        }
 
        long total = 0;
        for (int i = 0; i < K && !pq.isEmpty(); i++) {
            Mine top = pq.poll();
            total += top.value;
            long nextValue = top.value - top.decay;
            if (nextValue > 0) {
                pq.offer(new Mine(nextValue, top.decay));
            }
        }
 
        System.out.println(total);
    }
} 