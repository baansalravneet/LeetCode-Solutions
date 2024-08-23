class Solution {
    public String fractionAddition(String expression) {
        List<Integer> list = new ArrayList<>();
        getNumbers(list, expression);
        int num = 0, den = 1;
        for (int i = 0; i < list.size(); i += 2) {
            int a = list.get(i);
            int b = list.get(i+1);
            num = num*b + a*den;
            den *= b;
            int gcd = Math.abs(findGCD(num, den));
            num /= gcd;
            den /= gcd;
        }
        return num + "/" + den;
    }
    private int findGCD(int a, int b) {
        if (a == 0) return b;
        return findGCD(b % a, a);
    }
    private void getNumbers(List<Integer> list, String expression) {
        if (expression.charAt(0) != '-') expression = "+" + expression;
        for (int i = 0; i < expression.length(); ) {
            boolean negative = false;
            if (expression.charAt(i) == '-') {
                negative = true;
            }
            i++;
            int a = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                a *= 10;
                a += expression.charAt(i++) - '0';
            }
            if (negative) a = -a;
            list.addLast(a);
            i++;
            a = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                a *= 10;
                a += expression.charAt(i++) - '0';
            }
            list.addLast(a);
        }
    }
}

