import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());

        int[] materials = new int[N];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        for (int start = 0; start < N; start++) {
            int sum = 0;
            int end = start + 1;

            while (end < N) {
                sum = materials[start];
                sum += materials[end++];

                if (sum == M) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
        System.out.println(new BJ1940().count(N, M, materials));
    }

    private long count(int N, int M, int[] materials) {
        return IntStream.range(0, N)
                .filter(i ->
                        IntStream.range(i + 1, N)
                                .anyMatch(j -> materials[i] + materials[j] == M))
                .count();
    }
}
