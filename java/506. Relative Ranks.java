class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            answer.add(i);
        }
        Collections.sort(answer, (a,b) -> score[b] - score[a]);
        String[] result = new String[score.length];
        for (int i = 0; i < answer.size(); i++) {
            if (i == 0) result[answer.get(0)] = "Gold Medal";
            else if (i == 1) result[answer.get(1)] = "Silver Medal";
            else if (i == 2) result[answer.get(2)] = "Bronze Medal";
            else result[answer.get(i)] = String.valueOf(i+1);
        }
        return result;
    }
}