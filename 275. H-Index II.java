class Solution {
    public int hIndex(int[] arr) {
        if (arr.length == 1) {
            return arr[0] > 0 ? 1 : 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int papers = arr.length - mid;
            if (arr[mid] < papers) {
                answer = papers;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer == 0 ? arr.length : answer - 1;
    }
}

