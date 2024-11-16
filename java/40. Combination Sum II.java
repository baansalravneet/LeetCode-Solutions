class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        helper(answer, new ArrayList<Integer>(), candidates, target, 0, 0);
        return answer;
    }
    private void helper(List<List<Integer>> answer,
                        List<Integer> current,
                        int[] arr,
                        int target,
                        int index,
                        int sum) {
        if (index == arr.length) {
            if (sum == target) answer.add(new ArrayList<>(current));
            return;
        }
        if (sum > target) return;
        current.add(arr[index]);
        helper(answer, current, arr, target, index+1, sum + arr[index]);
        current.remove(current.size()-1);
        int i = index+1;
        while (i < arr.length && arr[i] == arr[index]) i++;
        helper(answer, current, arr, target, i, sum);
    }
}
