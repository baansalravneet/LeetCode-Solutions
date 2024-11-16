class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 0;
        int current = -1;
        for (int i : arr) {
            if (current == i) {
                count++;
            } else {
                count = 1;
                current = i;
            }
            if (100 * count > 25*arr.length) {
                return current;
            }
        }
        return -1;
    }
}
