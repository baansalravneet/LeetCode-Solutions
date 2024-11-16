class Solution {
    public String clearStars(String s) {
        List<Integer> deleteIndex = new ArrayList<>();
        PriorityQueue<CharacterIndex> heap = new PriorityQueue<>((a,b) -> {
            if (a.c == b.c) {
                return b.index - a.index;
            }
            return a.c - b.c;
        });
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                deleteIndex.add(heap.poll().index);
            } else {
                heap.add(new CharacterIndex(c, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(deleteIndex);
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index < deleteIndex.size() && i == deleteIndex.get(index)) index++;
            else if (s.charAt(i) != '*') sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
class CharacterIndex {
    char c;
    int index;
    CharacterIndex(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
