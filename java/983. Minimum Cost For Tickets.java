class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] cache = new Integer[days.length];
        return helper(days, costs, 0, cache);
    }
    private int helper(int[] days, int[] costs, int index, Integer[] cache) {
        if (index >= days.length) return 0;
        if (cache[index] != null) return cache[index];
        int originalIndex = index;
        int currentDay = days[index];
        int cost1 = costs[0] + helper(days, costs, index+1, cache);
        while (index < days.length && currentDay >= days[index] - 6) index++;
        int cost2 = costs[1] + helper(days, costs, index, cache);
        while (index < days.length && currentDay >= days[index] - 29) index++;
        int cost3 = costs[2] + helper(days, costs, index, cache);
        return cache[originalIndex] = Math.min(cost1, Math.min(cost2, cost3));
    }
}
