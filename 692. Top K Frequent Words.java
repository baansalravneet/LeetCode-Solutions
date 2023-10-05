class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<Pair<String, Integer>> freqPair = getFreqPair(words);
        Queue<Pair<String, Integer>> pq = new PriorityQueue<>((a,b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey().compareTo(a.getKey());
            } else {
                return a.getValue() - b.getValue();
            }
        });
        for (Pair<String, Integer> p : freqPair) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        LinkedList<String> answer = new LinkedList<>();
        while (!pq.isEmpty()) {
            answer.addFirst(pq.poll().getKey());
        }
        return answer;
    }
    private List<Pair<String, Integer>> getFreqPair(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w,0) + 1);
        }
        List<Pair<String, Integer>> answer = new ArrayList<>();
        for (String w : freq.keySet()) {
            answer.add(new Pair(w, freq.get(w)));
        }
        return answer;
    }
}
