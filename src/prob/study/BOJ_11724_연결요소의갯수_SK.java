package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의갯수_SK  {
    static int N, M, p[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N+1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        int count = 0;
        int ans = N;
        for (int i = 0; i < M  && count < N - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());
            if (union(from, to)) {
                count++;
                ans--;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    public static boolean union(int i, int j) {
        i = getParents(i);
        j = getParents(j);
        if (i == j) return false;

        if (i < j) {
            p[i] = j;
        } else {
            p[j] = i;
        }
        return true;
    }

    public static int getParents(int i) {
        if (p[i] == i) return i;

        return p[i] = getParents(p[i]);
    }
}
