class Solution {
    public int maxNumberOfAlloys(int n,
                                 int k,
                                 int budget,
                                 List<List<Integer>> composition,
                                 List<Integer> stock,
                                 List<Integer> cost)
    {
        int answer = 0;
        for (int i = 0; i < composition.size(); i++) {
            answer = Math.max(answer, find(composition.get(i), stock, cost, budget));
        }
        return answer;
    }
    private int find(List<Integer> composition, List<Integer> stock, List<Integer> cost, int budget) {
        int left = 0;
        int right = 1_000_000_000;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isPossible(composition, new ArrayList(stock), cost, budget, mid)) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }
    private boolean isPossible(List<Integer> composition,
                               List<Integer> stock,
                               List<Integer> cost,
                               int budget,
                               long target)
    {
        for (int j = 0; j < composition.size(); j++) {
            long required = composition.get(j) * target;
            long available = stock.get(j) + budget/cost.get(j);
            if (available < required) return false;
            if (stock.get(j) >= required) {
                stock.set(j, stock.get(j) - (int)required);
            } else {
                budget -= (required - stock.get(j))*cost.get(j);
                stock.set(j, 0);
            }
            if (budget < 0) return false;
        }
        return true;
    }
}

