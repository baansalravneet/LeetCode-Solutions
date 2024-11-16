class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int prevA = 0, prevB = 0, prevC = 0;
        while (true) {
            if (
                a > 0 && (
                    (prevB == 2 && a >= c) ||
                    (prevC == 2 && a >= b) ||
                    (prevA < 2 && a >= b && a >= c)
                )
            ) {
                sb.append('a');
                a--;
                prevA += 1;
                prevB = 0;
                prevC = 0;
                continue;
            } else if (
                b > 0 && (
                    (prevA == 2 && b >= c) ||
                    (prevC == 2 && b >= a) ||
                    (prevB < 2 && b >= a && b >= c)
                )
            ) {
                sb.append('b');
                b--;
                prevA = 0;
                prevB += 1;
                prevC = 0;
                continue;
            } else if (
                c > 0 && (
                    (prevA == 2 && c >= b) ||
                    (prevB == 2 && c >= a) ||
                    (prevC < 2 && c >= a && c >= b)
                )
            ) {
                sb.append('c');
                c--;
                prevA = 0;
                prevB = 0;
                prevC += 1;
                continue;
            }
            break;
        }
        return sb.toString();
    }
}