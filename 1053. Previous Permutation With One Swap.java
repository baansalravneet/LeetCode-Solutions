class Solution {
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int index = i+1;
                int number = arr[i+1];
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] > number && arr[i] > arr[j]) {
                        number = arr[j];
                        index = j;
                    }
                }
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                return arr;
            }
        }
        return arr;
    }
}

