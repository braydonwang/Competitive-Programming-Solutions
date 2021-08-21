import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        int arr[][] = new int [N+1][M+1];

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt(), c = sc.nextInt();
            arr[r][c] = 1;
        }
        int max = 0;
        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= M; b++) {
                if (arr[a][b] == 1) {
                    int cnt = 1;
                    Queue<Integer> q = new LinkedList();
                    q.add(a); q.add(b); arr[a][b] = 0;
                    while (!q.isEmpty()) {
                        int r = q.poll();
                        int c = q.poll();
                        if (r + 1 <= N && arr[r+1][c] == 1) {
                            q.add(r+1); q.add(c); cnt++; arr[r+1][c] = 0;
                        }
                        if (r - 1 > 0 && arr[r-1][c] == 1) {
                            q.add(r-1); q.add(c); cnt++; arr[r-1][c] = 0;
                        }
                        if (c + 1 <= M && arr[r][c+1] == 1) {
                            q.add(r); q.add(c+1); cnt++; arr[r][c+1] = 0;
                        }
                        if (c - 1 > 0 && arr[r][c-1] == 1) {
                            q.add(r); q.add(c-1); cnt++; arr[r][c-1] = 0;
                        }
                    }
                    max = Math.max(cnt, max);
                }
            }
        }
        System.out.println(max);
    }
}
