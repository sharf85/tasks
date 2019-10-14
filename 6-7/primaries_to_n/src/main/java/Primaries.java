import java.util.ArrayList;
import java.util.List;

public class Primaries {
    public List<Integer> getFirstUpToN(int N) {
        boolean[] isNotPrime = new boolean[N + 1];
        List<Integer> res = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (!isNotPrime[i]) {
                res.add(i);
                for (int j = i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        return res;
    }
}
