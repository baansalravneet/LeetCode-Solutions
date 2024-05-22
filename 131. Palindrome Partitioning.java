class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        populate(s, result, new ArrayList<>(), 0);
        return result;
    }
    private void populate(
        String s,
        List<List<String>> result,
        List<String> current,
        int index
    ) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i+1);
            if (palindrome(sub)) {
                current.add(sub);
                populate(s, result, current, i+1);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean palindrome(String s) {
        for (
            int left = 0, right = s.length()-1;
            left < right;
            left++, right--
        ) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}