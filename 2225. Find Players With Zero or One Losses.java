class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> players = new HashSet<>();
        Map<Integer, Integer> lossCount = new HashMap<>();
        for (int[] i : matches) {
            players.add(i[0]);
            players.add(i[1]);
            lossCount.put(i[1], lossCount.getOrDefault(i[1], 0) + 1);
        }
        Set<Integer> winners = new HashSet<>(players);
        for (int[] i : matches) {
            winners.remove(i[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> answer1 = new ArrayList<>(winners);
        List<Integer> answer2 = new ArrayList<>();
        for (int i : lossCount.keySet()) {
            if (lossCount.get(i) == 1) answer2.add(i);
        }
        Collections.sort(answer1);
        result.add(answer1);
        Collections.sort(answer2);
        result.add(answer2);
        return result;
    }
}
