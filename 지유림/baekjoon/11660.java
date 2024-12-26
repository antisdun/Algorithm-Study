import java.io.*;
import java.util.*;

public class Main11660_구간합구하기5 {
    static int N, M;
    static int[][] preSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        preSum = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                preSum[i][j] = preSum[i][j-1] + preSum[i-1][j] - preSum[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            result = preSum[x2][y2] - preSum[x1-1][y2] - preSum[x2][y1-1] + preSum[x1-1][y1-1];
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }
}
