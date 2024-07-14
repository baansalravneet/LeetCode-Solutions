class Solution {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length()-1; i++) {
            int digit1 = s.charAt(i)-'0';
            int digit2 = s.charAt(i+1)-'0';
            if (digit1%2==0 ^ digit2%2==0) continue;
            else {
                if (digit1 > digit2) {
                    swap(arr, i, i+1);
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}