// INI SOAL C

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Suzuka {
    static class State {
        long pos;
        int sta, steps;
        State(long pos, int sta, int steps) {
            this.pos = pos;
            this.sta = sta;
            this.steps = steps;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long D = Long.parseLong(st.nextToken());
        int t  = Integer.parseInt(st.nextToken());
        int h  = Integer.parseInt(st.nextToken());
        int E  = Integer.parseInt(st.nextToken());
        int e  = Integer.parseInt(st.nextToken());
        int r  = Integer.parseInt(st.nextToken());
        int Lmax = Integer.parseInt(st.nextToken());

        long LSuzuka = (D + t - 1) / t;
        int Llimit = (int) Math.min(LSuzuka, Lmax - 1);

        boolean[][] seen = new boolean[Llimit + 1][E + 1];
        Queue<State> q = new LinkedList<>();

        q.add(new State(0, E, 0));
        seen[0][E] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            long pos = cur.pos;
            int sta = cur.sta;
            int steps = cur.steps;

            if (pos >= D) {
                System.out.println(steps);
                return;
            }
            if (steps + 1 > Llimit) {
                continue;
            }

            int nextStep = steps + 1;

            if (sta >= e) {
                long npos = pos + h;
                if (npos > D) npos = D;
                int nsta = sta - e;
                if (!seen[nextStep][nsta]) {
                    seen[nextStep][nsta] = true;
                    q.add(new State(npos, nsta, nextStep));
                }
            }

            {
                long npos = pos + t;
                if (npos > D) npos = D;
                int nsta = Math.min(E, sta + 1);
                if (!seen[nextStep][nsta]) {
                    seen[nextStep][nsta] = true;
                    q.add(new State(npos, nsta, nextStep));
                }
            }

            {
                long npos = pos;
                int nsta = Math.min(E, sta + r);
                if (!seen[nextStep][nsta]) {
                    seen[nextStep][nsta] = true;
                    q.add(new State(npos, nsta, nextStep));
                }
            }
        }

        System.out.println(-1);
    }
}