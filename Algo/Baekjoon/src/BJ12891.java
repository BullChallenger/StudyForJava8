import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        final String DNAStr = br.readLine();

        HashMap<Character, Integer> count = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        count.put('A', -Integer.parseInt(st.nextToken()));
        count.put('C', -Integer.parseInt(st.nextToken()));
        count.put('G', -Integer.parseInt(st.nextToken()));
        count.put('T', -Integer.parseInt(st.nextToken()));

        Map<Character, Long> chars = DNAStr.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));


    }
}
