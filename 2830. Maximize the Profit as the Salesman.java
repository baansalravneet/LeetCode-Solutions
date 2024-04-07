class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> a.get(0) - b.get(0));
        Integer[] cache = new Integer[offers.size()];
        return helper(offers, 0, cache);
    }
    private int helper(List<List<Integer>> offers, int index, Integer[] cache) {
        if (index == offers.size()) return 0;
        if (cache[index] != null) return cache[index];
        int answer1 = helper(offers, index+1, cache);
        int answer2 = offers.get(index).get(2);
        int end = offers.get(index).get(1);
        int i = getNext(offers, index+1, offers.size()-1, end);
        answer2 += helper(offers, i, cache);
        return cache[index] = Math.max(answer1, answer2);
    }
    private int getNext(List<List<Integer>> offers, int left, int right, int end) {
        int answer = offers.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (offers.get(mid).get(0) > end) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}