import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class RecFibonacci {

    private Map<Integer, BigInteger> cache = new HashMap<>();

    public BigInteger compute(int n) {
        if (n < 2)
            return BigInteger.valueOf(n);

        if (cache.containsKey(n))
            return cache.get(n);

        BigInteger res = compute(n - 1).add(compute(n - 2));
        cache.put(n, res);

        return res;
    }


}
