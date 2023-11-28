class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int min = j < triangle.get(i-1).size() ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                min = Math.min(min, j > 0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE);
                triangle.get(i).set(j, min + triangle.get(i).get(j));
                if (i == triangle.size()-1) {
                    answer = Math.min(answer, triangle.get(i).get(j));
                }
            }
        }
        return answer == Integer.MAX_VALUE ? triangle.get(0).get(0) : answer;
    }
}
