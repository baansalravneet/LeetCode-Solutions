class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!q.isEmpty()) q.addFirst(q.pollLast());
            q.addFirst(deck[i]);
        }
        return q.stream().mapToInt(i -> i).toArray();
    }
}
