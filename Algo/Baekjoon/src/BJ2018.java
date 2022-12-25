import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int count = 1;

        for (int i = 1; i < N; i++) {
            int sum = i;
            for (int j = i + 1; j < N; j++) {
                sum += j;
                if (sum > N) break;
                else if (sum == N) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
