class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer[][] cache = new Integer[books.length][shelfWidth+1];
        return helper(books, shelfWidth, 0, 0, 0, cache);
    }
    private int helper(
        int[][] books,
        int width,
        int index,
        int maxHeight,
        int widthUsed,
        Integer[][] cache
    ) {
        if (index >= books.length) return maxHeight;
        if (cache[index][widthUsed] != null) return cache[index][widthUsed];
        int[] current = books[index];
        // new shelf
        int answer = maxHeight + helper(books, width, index+1, current[1], current[0], cache);
        // current shelf
        if (current[0]+widthUsed <= width) {
            answer = Math.min(
                answer,
                helper(books, width, index+1, Math.max(maxHeight, current[1]), widthUsed+current[0], cache)
            );
        }
        return cache[index][widthUsed] = answer;

    }
}