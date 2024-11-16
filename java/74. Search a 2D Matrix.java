class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = findRow(matrix, target);
        if (row == -1) return false;
        return findTarget(matrix[row], target);
    }
    private boolean findTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    private int findRow(int[][] matrix, int target) {
        int answer = -1;
        int left = 0;
        int right = matrix.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (matrix[mid][0] <= target) {
                answer = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }
}
