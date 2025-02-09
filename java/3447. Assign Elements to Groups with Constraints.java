class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int[] answer = new int[groups.length];
        Map<Integer, Integer> elementIndex = new HashMap<>();
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < elements.length; i++) {
            elementIndex.putIfAbsent(elements[i], i);
        }
        for (int i = 0; i < groups.length; i++) {
            for (int div : divisors(groups[i])) {
                if (!elementIndex.containsKey(div)) continue;
                answer[i] = Math.min(answer[i], elementIndex.get(div));
            }
            if (answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        }
        return answer;
    }
    private List<Integer> divisors(int num) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                answer.add(i);
                answer.add(num/i);
            }
        }
        return answer;
    }
}