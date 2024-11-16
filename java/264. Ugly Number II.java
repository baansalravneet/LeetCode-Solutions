class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer = set.pollFirst();
            set.add(answer * 2);
            set.add(answer * 3);
            set.add(answer * 5);
        }
        return (int)answer;
    }
}

