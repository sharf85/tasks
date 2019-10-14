public class GCD {
//    a,b > 0
    public long compute(long a, long b) {
        if (b == 0)
            return a;
        return compute(b, a % b);
    }

}
