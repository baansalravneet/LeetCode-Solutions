class Solution {
    public void duplicateZeros(int[] arr) {
        int finalLength = 0;
        for (int i : arr) {
            if (i == 0) finalLength++;
            finalLength++;
        }
        finalLength--;
        for (int i = arr.length-1; i >= 0; i--) {
            int current = arr[i];
            if (finalLength < arr.length) arr[finalLength] = current;
            finalLength--;
            if (current == 0) {
                if (finalLength < arr.length) arr[finalLength] = current;
                finalLength--;
            }
        }
    }
}

