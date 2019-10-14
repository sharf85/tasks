public class LCM {
    private GCD gcd;

    public LCM(GCD gcd) {
        this.gcd = gcd;
    }

    public long compute(long a, long b) {
        return a * b / gcd.compute(a, b);
    }
}
