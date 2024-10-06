class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] a = sentence1.split(" ");
        String[] b = sentence2.split(" ");
        return helper(a, b) || helper(b, a);
    }
    private boolean helper(String[] a, String[] b) {
        if (b.length > a.length) return false;
        int index = 0;
        int count = 0;
        while (index < b.length) {
            if (!a[index].equals(b[index])) break;
            index++;
            count++;
        }
        index = 0;
        while (index < b.length) {
            if (!a[a.length-1-index].equals(b[b.length-1-index])) break;
            index++;
            count++;
        }
        return count >= b.length;
    }
}
