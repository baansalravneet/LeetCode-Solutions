class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, k, n, 1, 0, new LinkedList<>());
        return result;
    }
    private void helper
    (
        List<List<Integer>> result,
        int k,
        int n,
        int currentNumber,
        int currentSum,
        LinkedList<Integer> currentResult
    )
    {
        if (currentResult.size() > k) return;
        if (currentSum > n) return;
        if (currentResult.size() == k && currentSum == n) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        for (int i = currentNumber; i <= 9; i++) {
            currentResult.add(i);
            helper(result, k, n, i+1, currentSum + i, currentResult);
            currentResult.pollLast();
        }
    }
}  
