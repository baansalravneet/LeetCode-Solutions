class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonals = new HashMap<>();
        int maxDiagonal = 0;
        int count = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = nums.get(i).size() - 1; j >= 0; j--) {
                int diagonal = i + j;
                count++;
                maxDiagonal = Math.max(maxDiagonal, diagonal);
                diagonals.computeIfAbsent(diagonal, k -> new ArrayList<>()).add(nums.get(i).get(j));
            }
        }
        int[] answer = new int[count];
        int index = 0;
        for (int i = 0; i <= maxDiagonal; i++) {
            List<Integer> current = diagonals.get(i);
            for (int x : current) {
                answer[index++] = x;
            }
        }
        return answer;
    }
}
