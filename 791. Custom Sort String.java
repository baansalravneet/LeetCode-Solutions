class Solution {
    public String customSortString(String order, String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> charIndex = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            charIndex.put(order.charAt(i), i);
        }
        bubbleSort(arr, charIndex);
        return new String(arr);
    }
    private void bubbleSort(char[] arr, Map<Character, Integer> charIndex) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (compare(arr[j], arr[j+1], charIndex)) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    private boolean compare(char a, char b, Map<Character, Integer> charIndex) {
        if (!charIndex.containsKey(a)) return true;
        if (!charIndex.containsKey(b)) return false;
        return charIndex.get(a) > charIndex.get(b);
    }
}
