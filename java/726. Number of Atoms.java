class Solution {
    public String countOfAtoms(String formula) {
        Deque<Integer> multiplier = new ArrayDeque<>();
        TreeMap<String, Integer> count = new TreeMap<>();
        int currentMultiplier = 1;
        int multiplierLength = 0;
        for (int i = formula.length()-1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (Character.isDigit(c)) {
                if (multiplierLength == 0) {
                    currentMultiplier = c-'0';
                } else {
                    currentMultiplier += (int)Math.pow(10, multiplierLength) * (c-'0');
                }
                multiplierLength++;
                continue;
            }
            if (c == '(') {
                multiplier.pollLast();
            } else if (c == ')') {
                multiplier.addLast(currentMultiplier *
                    (multiplier.isEmpty() ? 1 : multiplier.peekLast()));
            } else {
                String element;
                if (Character.isLowerCase(c)) {
                    element = formula.substring(i-1, i+1);
                    i--;
                } else {
                    element = formula.substring(i, i+1);
                }
                count.put(
                    element,
                    count.getOrDefault(element, 0) +
                        (multiplier.isEmpty() ?
                        currentMultiplier :
                        multiplier.peekLast() * currentMultiplier));
            }
            currentMultiplier = 1;
            multiplierLength = 0;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            String element = e.getKey();
            int value = e.getValue();
            sb.append(e.getKey());
            if (value > 1) sb.append(String.valueOf(e.getValue()));
        }
        return sb.toString();
    }
}