import java.math.BigInteger;

class Solution {
    private static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

    public int maximumXorProduct(long a, long b, int n) {
        BigInteger x = BigInteger.ZERO;
        BigInteger A = BigInteger.valueOf(a);
        BigInteger B = BigInteger.valueOf(b);
        BigInteger answer = A.multiply(B);
        for(int i = n-1; i >= 0; i--) {
            BigInteger candidate = x.setBit(i);
            BigInteger candidateAnswer = A.xor(candidate).multiply(B.xor(candidate));
            if(candidateAnswer.compareTo(answer) > 0) {
                answer = candidateAnswer;
                x = candidate;
            }
        }
        return Integer.parseInt(answer.mod(MOD).toString());
    }
}
